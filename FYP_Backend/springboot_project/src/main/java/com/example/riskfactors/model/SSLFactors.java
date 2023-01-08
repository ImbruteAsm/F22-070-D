package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter

public class SSLFactors {
    private String grade;
    private Boolean isSelfSigned;
    private Boolean isExpired;
    private Boolean isWeakCipher;
    private List<Vulnerability> vulnerabilities;
    private String issuedTo;
    private String issuedBy;
    private String cipher;
    private String issuedCountry;
    private String validFrom;
    private String validTill;

    public SSLFactors() {
        this.grade = "";
        this.isSelfSigned = false;
        this.isExpired = false;
        this.isWeakCipher = false;
        this.vulnerabilities = new ArrayList<>();
        this.issuedBy = "";
        this.issuedTo = "";
        this.cipher = "";
        this.issuedCountry = "";
        this.validFrom = "";
        this.validTill = "";
    }


}
