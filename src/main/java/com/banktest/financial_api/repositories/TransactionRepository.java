package com.banktest.financial_api.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banktest.financial_api.domain.entities.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    
    List<Transaction> findByAccOriginAndMomentBetween(String accOrigin, Instant start, Instant end);
    List<Transaction> findByAccDestinyAndMomentBetween(String accDestiny, Instant start, Instant end);
}
