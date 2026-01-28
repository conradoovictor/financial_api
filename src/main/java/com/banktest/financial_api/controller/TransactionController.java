package com.banktest.financial_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banktest.financial_api.domain.dtos.AccountDTO.DepositRequestDTO;
import com.banktest.financial_api.domain.dtos.TransactionDTO.TransactionRequestDTO;
import com.banktest.financial_api.domain.dtos.TransactionDTO.TransactionResponseDTO;
import com.banktest.financial_api.domain.entities.Transaction;
import com.banktest.financial_api.services.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> findAll() {
        List<TransactionResponseDTO> list = service.findAll()
                .stream()
                .map(TransactionResponseDTO::new)
                .toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> transaction(
            @RequestBody TransactionRequestDTO body) {

        return ResponseEntity.ok(
                new TransactionResponseDTO(service.execute(body)));
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponseDTO> deposit(
            @RequestBody @Valid DepositRequestDTO body) {

        Transaction tx = service.deposit(body);

        return ResponseEntity.ok(new TransactionResponseDTO(tx));
    }

}
