package com.example.riskfactors.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class NetworkSecurityFactors {
    @Id
    @SequenceGenerator(
            name ="network_sequence",
            sequenceName = "network_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "network_sequence"
    )
    private Integer id;
    private String service_factors;
    private String ports;
    private String ssl_factors;
    private String ssh_factors;
    private String subdomains;
    private Float risk_factor;

}
