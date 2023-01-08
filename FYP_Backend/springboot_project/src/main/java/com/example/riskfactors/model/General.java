package com.example.riskfactors.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class General {

    private Boolean enforceHttps;
    private Boolean CORSPolicy;
    private Boolean csp;
    private Boolean hsts;
    private Boolean xFrameOptions;
    private Boolean xContentTypeOptions;
    private Boolean unencryptedPwd;

}
