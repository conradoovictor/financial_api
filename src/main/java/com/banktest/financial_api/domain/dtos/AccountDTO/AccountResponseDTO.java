package com.banktest.financial_api.domain.dtos.AccountDTO;

import java.io.Serializable;

import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.domain.enums.AccountType;

public class AccountResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accNumber;
    private AccountType type;
    private Double balance;

    public AccountResponseDTO(Account account) {
        this.accNumber = account.getAccNumber();
        this.type = account.getType();
        this.balance = account.getBalance();
    }

    public String getAccNumber() {
        return accNumber;
    }

    public AccountType getType() {
        return type;
    }

    public Double getBalance() {
        return balance;
    }
}
