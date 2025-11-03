package com.banktest.financial_api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banktest.financial_api.domain.entities.Client;


@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findByCpf(String cpf);

}
