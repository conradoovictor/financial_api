package com.banktest.financial_api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banktest.financial_api.domain.entities.Client;


@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findByClientCpf(String clientCpf);
    Optional<Client> findByClientId(Integer clientId);
    Optional<Client> deleteByClientId(Integer clientId);

}