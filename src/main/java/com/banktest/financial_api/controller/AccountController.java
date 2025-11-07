package com.banktest.financial_api.controller;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banktest.financial_api.domain.dtos.AccountDTO;
import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.services.AccountService;
import com.banktest.financial_api.services.ClientService;
import com.banktest.financial_api.services.TransactionService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AccountDTO>> findAll() {
        List<AccountDTO> list = service.findAll().stream().map(AccountDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST)
    public ResponseEntity<AccountDTO> createAccount(@PathVariable Integer clientId, @RequestBody AccountDTO body) {
        Account acc = service.createAccount(clientId, body.getType(), body.getBalance());
        AccountDTO dto = new AccountDTO(acc);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findAccountsByClient(@PathVariable Integer clientId) {
        var obj = clientService.findByClientId(clientId);
        var accounts = service.findByClientId(clientId)
                .stream()
                .map(AccountDTO::new)
                .toList();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("ID do cliente", obj.getClientId());
        response.put("Nome do cliente", obj.getClientName());
        response.put("CPF do cliente", obj.getClientCpf());
        response.put("Contas", accounts);

        return ResponseEntity.ok(response);

    }

    @RequestMapping(value = "/{accNumber}/deposit", method = RequestMethod.POST)
    public ResponseEntity<AccountDTO> deposit(@PathVariable String accNumber, @RequestBody Map<String, Double> body) {
        Double value = body.get("value");
        Account acc = service.deposit(accNumber, value);
        AccountDTO dto = new AccountDTO(acc);

        return ResponseEntity.ok(dto);
    }

    @RequestMapping(value = "/{accNumber}/balance", method = RequestMethod.GET)
    public ResponseEntity<AccountDTO> findBalanceByAccNumber(@PathVariable String accNumber) {
        Account acc = service.findByAccountNumber(accNumber);
        AccountDTO dto = new AccountDTO(acc);
        return ResponseEntity.ok(dto);
    }

    @RequestMapping(value = "/{accNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> delete(@PathVariable String accNumber) {
        service.delete(accNumber);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{accNumber}/transactions", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> transactions(@PathVariable String accNumber, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
        Instant start = Instant.parse(startDate + "T00:00:00Z");
        Instant end = Instant.parse(endDate + "T00:00:00Z");

        Map<String, Object> response = transactionService.getTransactions(accNumber, start, end);
        return ResponseEntity.ok(response);
    }
}
