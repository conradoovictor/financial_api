package com.banktest.financial_api.controller;

import java.time.Instant;
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

import com.banktest.financial_api.domain.entities.Transaction;
import com.banktest.financial_api.services.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Transaction> transaction(@RequestBody Transaction obj) {
        Transaction created = service.transaction(obj);
        return ResponseEntity.ok().body(created);
    }

    @RequestMapping(value = "/accounts/{accNumber}/transactions", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> transactions(@PathVariable String accNumber, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
        Instant start = Instant.parse(startDate + "T00:00:00Z");
        Instant end = Instant.parse(endDate + "T00:00:00Z");

        Map<String, Object> response = service.getTransactions(accNumber, start, end);
        return ResponseEntity.ok(response);
    }

}
