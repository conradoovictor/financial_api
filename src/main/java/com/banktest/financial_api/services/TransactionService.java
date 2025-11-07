package com.banktest.financial_api.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> getTransactions(String accNumber, Instant start, Instant end) {

        Account acc = service.findByAccountNumber(accNumber);

        List<Transaction> sentTransactions = repo.findByAccOriginAndMomentBetween(accNumber, start, end);
        List<Transaction> receivedTransactions = repo.findByAccDestinyAndMomentBetween(accNumber, start, end);

        List<Map<String, Object>> sentList = new ArrayList<>();
        for (Transaction t : sentTransactions) {
            Map<String, Object> tx = new LinkedHashMap<>();
            tx.put("Data", t.getMoment());
            tx.put("Valor", t.getValue());
            tx.put("Conta destino", t.getAccDestiny());
            tx.put("Tipo", t.getType());
            sentList.add(tx);
        }

        List<Map<String, Object>> receivedList = new ArrayList<>();
        for (Transaction t : receivedTransactions) {
            Map<String, Object> tx = new LinkedHashMap<>();
            tx.put("Data", t.getMoment());
            tx.put("Valor", t.getValue());
            tx.put("Conta destino", t.getAccOrigin());
            tx.put("Tipo", t.getType());
            receivedList.add(tx);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Conta", acc.getAccNumber());
        response.put("Saldo atual", acc.getBalance());
        response.put("Transações enviadas", sentList);
        response.put("Transações recebidas", receivedList);

        return response;
    }
}

