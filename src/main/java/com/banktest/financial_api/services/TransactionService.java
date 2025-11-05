package com.banktest.financial_api.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.domain.entities.Transaction;
import com.banktest.financial_api.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    @Autowired
    private AccountService service;

    public List<Transaction> findAll() {
        return repo.findAll();
    }

    public Transaction transaction(Transaction obj) {
        if (obj.getAccDestiny().equals(obj.getAccOrigin())) {
            throw new RuntimeException("A transação deve ser feita através de contas distintas");
        }

        Account origin = service.findByAccountNumber(obj.getAccOrigin());
        Account destiny = service.findByAccountNumber(obj.getAccDestiny());

        if (origin.getBalance() < obj.getValue()) {
            throw new RuntimeException("Saldo insuficiente para efetuar a transação");
        }

        origin.setBalance(origin.getBalance() - obj.getValue());
        destiny.setBalance(destiny.getBalance() + obj.getValue());

        service.update(origin);
        service.update(destiny);

        obj.setMoment(Instant.now());
        return repo.save(obj);

    }

}