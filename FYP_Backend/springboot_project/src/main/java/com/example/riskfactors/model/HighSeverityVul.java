package com.example.riskfactors.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HighSeverityVul {
    private Boolean xss;
    private Boolean csrf;
    private Boolean sqlI;
}
