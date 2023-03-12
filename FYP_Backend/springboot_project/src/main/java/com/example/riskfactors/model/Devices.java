package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Devices {
    private List<Hostname> hosts;
    private int total;
    private int up;
    private int down;
    private String addrType;
    private String addr;


}
