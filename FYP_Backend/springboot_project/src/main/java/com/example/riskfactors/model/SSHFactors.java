package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

public class SSHFactors {
    private int sshVersion;
    private List<String> ciphers;
    private List<String> mac;

    public SSHFactors() {
        this.sshVersion = 0;
        this.ciphers = new ArrayList<>();
        this.mac = new ArrayList<>();
    }

}
