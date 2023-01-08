package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NetworkSecurityFactors {

    private ServiceFactors serviceFactors;

    private SSLFactors sslFactors;

    private SSHFactors sshFactors;

    private List<Subdomain> subdomains;
    private float riskFactor;


    public NetworkSecurityFactors() {
        this.serviceFactors = new ServiceFactors();
        this.sslFactors = new SSLFactors();
        this.sshFactors = new SSHFactors();
        this.subdomains = new ArrayList<>();
        this.riskFactor = 0;
    }

}
