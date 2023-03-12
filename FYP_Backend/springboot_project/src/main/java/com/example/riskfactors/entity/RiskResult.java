package com.example.riskfactors.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "risk_results")
public class RiskResult {
    @Id
    @SequenceGenerator(
            name = "risk_results_sequence",
            sequenceName = "risk_results_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "risk_results_sequence"
    )
    private long id;
    private String target;
    private String application_security_result;
    private String network_security_result;
    private String dns_result;
    private String ip_reputation_result;
    private String endpoint_security_result;
}
