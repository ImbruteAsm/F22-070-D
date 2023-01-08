package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DNSHealth {
    private float riskScore;
    private boolean isOpenDNSDetected = false;

    private SPF spf;
    private List<String> ns;
    private List<String> mx;
    private List<String> txt;
    private List<String> a;
    private List<String> quadA;
    private List<String> aName;
    private List<String> cName;
    private List<String> soa;
    private List<String> srv;
    private List<String> ptr;

    public DNSHealth() {
        spf = new SPF();
        this.ns = new ArrayList<>();
        this.mx = new ArrayList<>();
        this.txt = new ArrayList<>();
        this.a = new ArrayList<>();
        this.quadA = new ArrayList<>();
        this.aName = new ArrayList<>();
        this.cName = new ArrayList<>();
        this.soa = new ArrayList<>();
        this.srv = new ArrayList<>();
        this.ptr = new ArrayList<>();

    }


}
