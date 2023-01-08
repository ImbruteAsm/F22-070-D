package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IpReputation {

    private Malware malwareInfection;
    private float riskFactor;

    public IpReputation() {
        this.malwareInfection = new Malware();
        this.riskFactor = 0f;
    }

}
