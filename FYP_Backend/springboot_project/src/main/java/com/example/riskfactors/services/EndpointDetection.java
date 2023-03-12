package com.example.riskfactors.services;

import com.example.riskfactors.model.*;
import com.example.riskfactors.utils.Constants;
import com.example.riskfactors.utils.Parser;
import com.example.riskfactors.utils.RunProcess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.rmi.server.ExportException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class EndpointDetection {

    public Devices detectEndpoint(String target){
       // String os = detectOperatingSystem(target);
      //  String service = detectServices(target);
        Devices devices = discoverdDevices(target);

       // String results = os + service + devices;
        //return results;
        return devices;
    }

    public List<OperatingSytem> detectOperatingSystem(String target){
        String cmdTemplate = Constants.OPERATINGSYSTEM_CMD;
        String fileName = this.makeFile("operatingsystem", "xml");
        RunProcess process = new RunProcess();
        String operatingsystemCmd = String.format(cmdTemplate, target, fileName);
        System.out.println(operatingsystemCmd);
        Boolean isFinished = process.runProcess(operatingsystemCmd);
        if (isFinished.equals(Boolean.TRUE)) {
            Parser converter = new Parser();
            try {
                String jsonString = converter.convert(fileName);
                System.out.println("file created= "); System.out.println(fileName);
                //return jsonString;
                System.out.println("returning");
                return parseOperatingSystem(jsonString);
                //return jsonString;
            } catch (Exception e) {
                //log.error("Exception in Kafka NetworkDiscovery->discoverSubDomains Method :{} ", e.getMessage());
            }
        }
        return null;
    }

    public List<OperatingSytem> parseOperatingSystem(String jsonString){
        JSONObject data = new JSONObject(jsonString);
        boolean isHostThere = false;
        String fin=null;
        List<OperatingSytem> operatingSytemList = new ArrayList<>();
        JSONObject os = null;
        try {
            isHostThere = data.getJSONObject("nmaprun").has("host");
            if (isHostThere) {
                JSONObject hostData = data.getJSONObject("nmaprun").getJSONObject("host");

                boolean isOSThere = false;
                isOSThere = hostData.has("os");


                if (isOSThere) {

                    os = hostData.getJSONObject("os");
                    boolean isThereOsmatch = false;
                    isThereOsmatch = os.has("osmatch");
                    if(isThereOsmatch){
                        JSONArray OS = os.getJSONArray("osmatch");
                        for(int i=0; i<OS.length();i++){

                            System.out.println(i);
                            OperatingSytem operatingSytem= new OperatingSytem();

                            JSONObject element = OS.getJSONObject(i);
                            boolean isThereClass = false, isTherefamily= false, isTheretype = false,
                                    isTherename=false, isTherecpe = false, isTHerevendor = false;
                            isThereClass = element.has("osclass");
                            if(isThereClass) {
                                JSONObject ops = element.getJSONObject("osclass");
                                isTherecpe = ops.has("cpe");
                                isTherename = ops.has("name");
                                isTHerevendor = ops.has("vendor");
                                isTheretype = ops.has("type");
                                isTherefamily = ops.has("osfamily");

                                if(isTherefamily) {
                                    operatingSytem.setOSFamily(ops.getString("osfamily"));
                                }
                                if(isTheretype) {
                                    operatingSytem.setType(ops.getString("type"));
                                }
                                if(isTherename) {
                                    operatingSytem.setOSname(ops.getString("name"));
                                }
                                if(isTherecpe) {
                                    operatingSytem.setCPE(ops.getString("cpe"));
                                }
                                if(isTHerevendor) {
                                    operatingSytem.setOSvendor(ops.getString("vendor"));
                                }
                            }
                            operatingSytemList.add(operatingSytem);
                        }
                    }
                }
                System.out.println(operatingSytemList.toString());
                return operatingSytemList;
            }
        }catch (Exception e){
            log.error("Error in parseOperatingSystem ", e);
        }
        return null;
    }

    public List<Services> detectServices(String target){
        String cmdTemplate = Constants.SERVICE_CMD;
        String fileName = this.makeFile("detectservice", "xml");
        RunProcess process = new RunProcess();
        String detecctServiceCmd = String.format(cmdTemplate, target, fileName);
        System.out.println(detecctServiceCmd );
        Boolean isFinished = process.runProcess(detecctServiceCmd );
        if (isFinished.equals(Boolean.TRUE)) {
            Parser converter = new Parser();
            try {
                String jsonString = converter.convert(fileName);
                System.out.println("file created= "); System.out.println(fileName);
                //return jsonString;
                System.out.println("returning");
                List<Services> testing = new ArrayList<>();
                testing = parseDetectedServices(jsonString);
                System.out.println(testing.toString());
                return parseDetectedServices(jsonString);
                //return jsonString;
            } catch (Exception e) {
                //log.error("Exception in Kafka NetworkDiscovery->discoverSubDomains Method :{} ", e.getMessage());
            }
        }
        return null;

    }

    public List<Services> parseDetectedServices(String jsonString){
        JSONObject data = new JSONObject(jsonString);
        boolean isServiceThere = false;
        String fin=null;
        List<Services> serviceList = new ArrayList<>();
        try {
            isServiceThere = data.getJSONObject("nmaprun").getJSONObject("host").has("ports");
            System.out.println("isServiceThere = " + isServiceThere);
            if (isServiceThere) {
                JSONObject serviceData = data.getJSONObject("nmaprun").getJSONObject("host").getJSONObject("ports");
                boolean isTherePort = false;
                isTherePort = serviceData.has("port");
                if(isTherePort){
                    System.out.println("found it");
                    JSONArray portList = serviceData.getJSONArray("port");
                    for (int i = 0; i < portList.length(); i++) {
                        System.out.println(i);
                        Services service= new Services();

                        JSONObject element = portList.getJSONObject(i);

                        boolean isThereProtocol = false;
                        isThereProtocol = element.has("protocl");
                        if(isThereProtocol){
                        service.setProtocol(element.getString("protocol"));
                        }

                        boolean isTherePortid = false;
                        isTherePortid = element.has("portid");
                        if(isTherePortid){
                            service.setPortID(element.getInt("portid"));
                        }


                        boolean isThereServ = false;
                        isThereServ = element.has("service");
                        if(isThereServ) {

                            JSONObject serviceObj = element.getJSONObject("service");
                            boolean isThereName = false, isThereConf = false, isThereMethod = false,
                                    isThereOSType = false, isThereProduct = false, isThereVersion = false;
                            isThereConf = serviceObj.has("conf");
                            isThereMethod = serviceObj.has("method");
                            isThereOSType = serviceObj.has("ostype");
                            isThereProduct = serviceObj.has("product");
                            isThereVersion = serviceObj.has("version");
                            isThereName = serviceObj.has("name");

                            if(isThereName) {
                                service.setName(serviceObj.getString("name"));
                            }
                            if(isThereConf) {
                                service.setConf(serviceObj.getInt("conf"));
                            }
                            if(isThereMethod) {
                                service.setMethod(serviceObj.getString("method"));
                            }
                            if(isThereOSType) {
                                service.setOStype(serviceObj.getString("ostype"));
                            }
                            if(isThereProduct) {
                                service.setProduct(serviceObj.getString("product"));
                            }
                            if(isThereVersion) {
                                service.setVersion(serviceObj.getInt("version"));
                            }

                        }
                      //  service.setCpe(serviceObj.getString("cpe"));
                        System.out.println(service.toString());
                        serviceList.add(service);
                    }

                }

                return serviceList;
            }
        }catch (Exception e){
            log.error("Error in ParseService ", e);
        }
        return null;
    }
    public Devices discoverdDevices(String target) {

        String cmdTemplate = Constants.DETECTEDDEVICES_CMD;
        System.out.println(cmdTemplate);
        String fileName = this.makeFile("detecteddevice", "xml");
        System.out.println("im here in the endpoint detection filename=  " + fileName);
     //   System.out.println(fileName);
        RunProcess process = new RunProcess();
        String detecteddeviceCmd = String.format(cmdTemplate, target, fileName);
        System.out.println(detecteddeviceCmd);
        Boolean isFinished = process.runProcess(detecteddeviceCmd );
        System.out.println("helo");
        if (isFinished.equals(Boolean.TRUE)) {
            Parser converter = new Parser();
            try {
                String jsonString = converter.convert(fileName);
                System.out.println("file created= "); System.out.println(fileName);
                return parseDetectedDevices(jsonString);
                //return jsonString;
            } catch (Exception e) {
                //log.error("Exception in Kafka NetworkDiscovery->discoverSubDomains Method :{} ", e.getMessage());
            }
        }
        return null;
    }

    private Devices parseDetectedDevices(String jsonString){
        JSONObject data = new JSONObject(jsonString);
        List<Hostname> hostnameList = new ArrayList<>();
        boolean isHostThere = false, isRunstatsThere = false;
        String fin=null;
        Devices devi = new Devices();
        //devices = null;

        JSONObject address= null, hostnames=null, status=null, runstats=null;
        try {
            isHostThere = data.getJSONObject("nmaprun").has("host");
            if (isHostThere){
                JSONObject hostData = data.getJSONObject("nmaprun").getJSONObject("host");
                boolean isAddressThere = false, isHostnamesThere= false, isStatusThere=false;
                isAddressThere = hostData.has("address");
                isHostnamesThere = hostData.has("hostnames");
                isStatusThere = hostData.has("status");
                if(isAddressThere){
                    address = hostData.getJSONObject("address");
                    String s = address.toString();
                    System.out.println("Caliing Address =" + s);
                   // address = hostData.getJSONObject("address");
                    devi.setAddrType(address.getString("addrtype"));
                    devi.setAddr(address.getString("addr"));

                }
                if(isHostnamesThere){
                    JSONArray hostname = hostData.getJSONObject("hostnames").getJSONArray("hostname");
                   System.out.println(hostname.toString());
                    for (int i = 0; i < hostname.length(); i++) {
                        System.out.println(i);
                        Hostname host = new Hostname();
                        JSONObject element = hostname.getJSONObject(i);

                                host.setHostName(element.getString("name"));

                                host.setHostType(element.getString("type"));

                        hostnameList.add(host);
                    }
                   devi.setHosts(hostnameList);
                }

                System.out.println("reached");


            }
            isRunstatsThere = data.getJSONObject("nmaprun").has("runstats");
            //System.out.println("isrunstates = " + isRunstatsThere);
            if(isRunstatsThere){
                JSONObject runstatsData = data.getJSONObject("nmaprun").getJSONObject("runstats");
                boolean isRunstats = false;
                isRunstats = runstatsData.has("hosts");
                //System.out.println("isrunst = " + isRunstats);
                if(isRunstats){
                    runstats = runstatsData.getJSONObject("hosts");
                    System.out.println(runstats.toString());
                    devi.setTotal(runstats.getInt("total"));
                    devi.setUp(runstats.getInt("up"));
                    devi.setDown(runstats.getInt("down"));
                }
            }
            return devi;

        }catch (Exception e){
            log.error("Exception in EndpointDetection -> parseDetectedDevices` Method :{} ", e.getMessage());
        }
        return null;
    }



    private String makeFile(String serviceName, String extension) {
        System.out.println("Are you making the file??");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss-yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        return "scan-" + serviceName + time + "." + extension;
    }
}
