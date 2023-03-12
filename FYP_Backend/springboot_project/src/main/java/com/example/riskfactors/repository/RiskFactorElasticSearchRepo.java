package com.example.riskfactors.repository;

import com.example.riskfactors.model.Result;
import com.example.riskfactors.model.RiskFactors;
import com.example.riskfactors.services.EndpointDetection;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//DO IT HERE!! best
//wrong -> Endpoint ko RiskFactorkaro!
//we have to add the result of each class, endpt, app sec waghera, then why riskfactors? got it
@Repository
public interface RiskFactorElasticSearchRepo extends ElasticsearchRepository<Result, String> {
//    List<RiskFactors> findByTitle(String title);
}
