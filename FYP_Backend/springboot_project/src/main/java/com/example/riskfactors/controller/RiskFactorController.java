package com.example.riskfactors.controller;


import com.example.riskfactors.model.RiskFactors;
import com.example.riskfactors.services.Enrichment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping
public class RiskFactorController {

    @Autowired
    private Enrichment enrichment;




    @GetMapping("/scan")
    public ResponseEntity<RiskFactors> scan(String target) throws IOException {
        try {
            log.info("Detected input :{}", target);

            RiskFactors riskFactors = enrichment.getFactors("flexstudent.nu.edu.pk/Login");
            if (riskFactors == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(riskFactors);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
