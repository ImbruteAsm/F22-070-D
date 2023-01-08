package com.example.riskfactors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.riskfactors.entity.Record;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    boolean existsRecordByTarget(String target);
    List<Record> findByTarget(String target);
}