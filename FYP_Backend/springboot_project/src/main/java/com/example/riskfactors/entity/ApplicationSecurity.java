package com.example.riskfactors.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationSecurity {
    @Id
    private Integer id;
    private String cookies;
    private String general;
    private String high_severity_vulnerablilities;
    private Float risk_factor;
}
