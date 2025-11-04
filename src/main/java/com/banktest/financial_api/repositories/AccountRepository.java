package com.banktest.financial_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banktest.financial_api.domain.entities.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{
    
}
