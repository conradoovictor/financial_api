package com.banktest.financial_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.services.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAll() {
        List<Account> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByClientId(@PathVariable String clientId) {
        List<Account> list = service.findByClientId(clientId);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}/balance", method = RequestMethod.GET)
    public ResponseEntity<Account> consultBalance(@PathVariable String id) {
        Account account = service.findById(id);
        return ResponseEntity.ok().body(account);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Account account) {
        account = service.insert(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
