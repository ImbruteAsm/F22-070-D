package com.example.riskfactors.controller;


import com.example.riskfactors.entity.Results;
import com.example.riskfactors.entity.RiskResult;
import com.example.riskfactors.model.Result;
import com.example.riskfactors.model.RiskFactors;
import com.example.riskfactors.repository.RiskFactorElasticSearchRepo;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.example.riskfactors.services.Enrichment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@ResponseBody
@Slf4j
@RequestMapping
public class RiskFactorController {

    @Autowired
    private RiskFactorElasticSearchRepo riskFactorElasticSearchRepo;

    @Autowired
    private Enrichment enrichment;
    @Autowired
    private ObjectMapper mapper;

    @CrossOrigin(origins = "*")
    @GetMapping("/scan")
    public ResponseEntity<String> scan(String target) throws IOException {
        try {
                log.info("Detected input :{}", target);
//            EndpointDetection endpointDetection = new EndpointDetection();
//            List<OperatingSytem> endpointDetectionJsonString = endpointDetection.detectOperatingSystem(target);
//           String output = mapper.writeValueAsString(endpointDetectionJsonString);
//                  System.out.println(output);
//      //      return new ResponseEntity<>(endpointDetectionJsonString, HttpStatus.OK);
//           // return output;
//            return null;
                RiskFactors riskFactors = enrichment.getFactors(target);
                if (riskFactors == null) {
                    return ResponseEntity.notFound().build();
                }

                try{

                    System.out.println("Json Printing");
                    //System.out.println(riskFactors);
                    System.out.println("Reached the System");
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String output = mapper.writeValueAsString(riskFactors);
                    //System.out.println(output);
                    System.out.println("Target:");
                    ObjectWriter tgt = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String TGT = tgt.writeValueAsString(riskFactors.getTarget());
                    System.out.println(TGT);

                    System.out.println("Network Security Factors:");
                    ObjectWriter nsf = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String NSF = nsf.writeValueAsString(riskFactors.getNetworkSecurityFactors());
                    System.out.println(NSF);

                    System.out.println("IP Reputation:");
                    ObjectWriter ip = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String IP = ip.writeValueAsString(riskFactors.getIpReputation());
                    System.out.println(IP);

                    System.out.println("DNS Health:");
                    ObjectWriter dns = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String DNS = dns.writeValueAsString(riskFactors.getDnsHealth());
                    System.out.println(DNS);

                    System.out.println("Application Security");
                    ObjectWriter app = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String APP = app.writeValueAsString(riskFactors.getApplicationSecurityFactors());
                    System.out.println(APP);

                    System.out.println("Endpoint Security:");

                    ObjectWriter end = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String END = end.writeValueAsString(riskFactors.getEndpointSecurity());
                    System.out.println(END);
                    System.out.println("Completed the System");
                    try {
                        System.out.println("this wont't work!");
                        Result res = new Result();
                        res.setTarget(target);
                        res.setResults(output);
                        this.riskFactorElasticSearchRepo.save(res);
                    } catch (Exception e) {
                        System.out.println("LOL!");
                        e.printStackTrace();
                    }

                    return new ResponseEntity<>(output, HttpStatus.OK);

                }
                catch(IOException e){
                    log.debug("Failed to convert", e);
                }
                return null;

        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }

    }

}
