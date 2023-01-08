package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RiskFactors {
    private String target;

    private NetworkSecurityFactors networkSecurityFactors;

    private DNSHealth dnsHealth;

    private ApplicationSecurity applicationSecurityFactors;
    private IpReputation ipReputation;
    private float riskNumber;

    public RiskFactors(NetworkSecurityFactors networkSecurityFactors, DNSHealth dnsHealth, ApplicationSecurity applicationSecurityFactors, IpReputation ipRepuation) {

        this.networkSecurityFactors = networkSecurityFactors;
        this.dnsHealth = dnsHealth;
        this.applicationSecurityFactors = applicationSecurityFactors;
        this.ipReputation = ipRepuation;
        this.riskNumber = 0f;
    }

}
