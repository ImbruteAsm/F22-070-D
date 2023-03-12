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
public class EndpointSecurity {
    @Id
    private Integer id;
    private String detected_devices;
    private String detected_services;
    private String endpoint_operating_system;
    private Float risk_factor;
}
