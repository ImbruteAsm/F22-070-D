package com.example.riskfactors.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndpointSecurity {
    private Devices detectedDevices;
    private List<Services> detectedServices;

    private List<OperatingSytem> endpointOperatingSystem;
//    private List<Devices> endpointDevices;
//    private List<Serives> endpointServices;
//
//    public EndpointSecurity(List<OperatingSytem> endpointOS, List<Devices> endpointDevices, List<Serives> endpointServices){
//        this.endpointDevices = endpointDevices;
//        this.endpointOS= endpointOS;
//        this.endpointDevices = endpointDevices;
//
//    }


}
