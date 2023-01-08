package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationSecurity {

    private Cookies cookies;

    private General general;

    private HighSeverityVul highSeverityVul;
    private float riskNumber;


    public ApplicationSecurity(Cookies cookies, General general, HighSeverityVul highSeverityVul) {
        this.cookies = cookies;
        this.general = general;
        this.highSeverityVul = highSeverityVul;
        this.riskNumber = 0;
    }


}
