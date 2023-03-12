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
public class risk_results {
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
    private String json_result;
}
