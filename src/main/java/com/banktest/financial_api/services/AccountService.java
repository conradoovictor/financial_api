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
    private ClientService clientService;

    public List<Account> findAll() {
        return repo.findAll();
    }

    public Account findById(String id) {
        Optional<Account> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
    }

    public Account createAccount(String clientId, AccountType type) {
        var client = clientService.findById(clientId);
        String number = generateAccountNumber();
        Account acc = new Account(client.getId(), number, type, 0.0);
        return repo.save(acc);
    }

    private String generateAccountNumber() {
        int random = (int) (Math.random() * 900) + 100;
        return String.valueOf(random);
    }

    public Double consultBalance(String clientId) {
        Account account = repo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada para o cliente informado"));
        return account.getBalance();
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

}
