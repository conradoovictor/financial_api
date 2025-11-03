package com.banktest.financial_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.repositories.AccountRepository;
import com.banktest.financial_api.services.exception.ObjectNotFoundException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    public List<Account> findAll() {
        return repo.findAll();
    }

    public Account findById(String id) {
        Optional<Account> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada"));
    }

    public Account insert(Account obj) {
        obj.setId(null);
        obj.setBalance(0.0);

        if (obj.getAccountNumber() == null) {
            obj.setAccountNumber(generateAccountNumber());
        }

        return repo.save(obj);
    }

    public Double consultBalance(String id) {
        Account account = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
        return account.getBalance();
    }

    public List<Account> findByClientId(String clientId) {
        return repo.findByClientId(clientId);
    }

    private String generateAccountNumber() {
        int random = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(random);
    }
}
