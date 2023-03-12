package com.example.riskfactors.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Setter
@Getter
@Document(indexName = "riskFactors", createIndex = true)
public class Result {
    @Id
    private String target;

    private String results;
}
