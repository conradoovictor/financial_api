package com.banktest.financial_api.controller;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banktest.financial_api.domain.dtos.AccountDTO.AccountRequestDTO;
import com.banktest.financial_api.domain.dtos.AccountDTO.AccountResponseDTO;
import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.services.AccountService;
import com.banktest.financial_api.services.TransactionService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(
            @RequestBody AccountRequestDTO body) {
        Account acc = service.createAccount(body.getClientId(), body.getType());
        return ResponseEntity.ok(new AccountResponseDTO(acc));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> findAll() {

        List<AccountResponseDTO> list = service.findAll()
                .stream()
                .map(AccountResponseDTO::new)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{accNumber}")
    public ResponseEntity<AccountResponseDTO> findByAccNumber(
            @PathVariable String accNumber) {

        Account acc = service.findByAccountNumber(accNumber);
        return ResponseEntity.ok(new AccountResponseDTO(acc));
    }

    @GetMapping("/{accNumber}/balance")
    public ResponseEntity<Double> getBalance(
            @PathVariable String accNumber) {

        Double balance = service.getBalance(accNumber);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/{accNumber}/transactions")
    public ResponseEntity<Map<String, Object>> getTransactions(
            @PathVariable String accNumber,
            @RequestParam Instant startDate,
            @RequestParam Instant endDate) {

        Map<String, Object> response = transactionService.getTransactions(accNumber, startDate, endDate);

        return ResponseEntity.ok(response);

    }
}
