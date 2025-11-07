package com.banktest.financial_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.domain.enums.AccountType;
import com.banktest.financial_api.repositories.AccountRepository;
import com.banktest.financial_api.services.exception.ObjectNotFoundException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    @Autowired
    private ClientService service;

    public List<Account> findAll() {
        return repo.findAll();
    }

    public Account createAccount(Integer clientId, AccountType type, Double balance) {
        var client = service.findByClientId(clientId);
        String number = generateAccountNumber();
        Account acc = new Account(client.getClientId(), number, type, 0.0);
        return repo.save(acc);
    }

    private String generateAccountNumber() {
        int random = (int) (Math.random() * 900) + 100;
        return String.valueOf(random);
    }

    public List<Account> findByClientId(Integer clientId) {
        return repo.findByClientId(clientId);
    }

    public Account update(Account account) {
        Account existing = findByAccountNumber(account.getAccNumber());
        existing.setBalance(account.getBalance());
        return repo.save(account);
    }

    public Account findByAccountNumber(String accNumber) {
        Optional<Account> obj = repo.findByAccNumber(accNumber);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada"));
    }
    public Account deposit(String accNumber, Double value){
        Account acc = findByAccountNumber(accNumber);
        acc.setBalance(acc.getBalance() + value);
        return repo.save(acc);
    }

     public void delete(String accNumber) {
        findByAccountNumber(accNumber);
        repo.deleteByAccNumber(accNumber);
    }

}