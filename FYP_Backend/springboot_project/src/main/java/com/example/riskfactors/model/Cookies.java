package com.example.riskfactors.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cookies {
    private Boolean httpOnly;
    private Boolean secure;


}
