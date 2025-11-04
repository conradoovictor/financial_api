package com.banktest.financial_api.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.services.AccountService;
import com.banktest.financial_api.services.ClientService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAll() {
        List<Account> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(
            @PathVariable String clientId,
            @RequestBody Account body) {
        Account acc = service.createAccount(clientId, body.getType());
        return ResponseEntity.ok(acc);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAccountByClientId(@PathVariable String clientId) {
        var client = clientService.findById(clientId);
        var account = service.findById(clientId);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("ID", client.getId());
        response.put("Nome", client.getName());
        response.put("CPF", client.getCpf());
        response.put("Data de nascimento", client.getBirthDate());

        Map<String, Object> accInfo = new LinkedHashMap<>();
        accInfo.put("Número da conta", account.getAccNumber());
        accInfo.put("Tipo", account.getType());
        accInfo.put("Saldo", account.getBalance());

        response.put("Conta", accInfo);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/{clientId}/balance", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> consultBalanceById(@PathVariable String clientId) {
        Account account = service.findById(clientId);
        Map<String, Object> response = new HashMap<>();
        response.put("Número da conta", account.getAccNumber());
        response.put("Saldo", account.getBalance());
        return ResponseEntity.ok(response);
    }

}
