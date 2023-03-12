package com.example.riskfactors.repository;

import com.example.riskfactors.entity.NetworkSecurityFactors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepository extends JpaRepository <NetworkSecurityFactors,Integer>{


}
