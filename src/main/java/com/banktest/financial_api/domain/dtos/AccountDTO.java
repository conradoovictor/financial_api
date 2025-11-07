package com.banktest.financial_api.domain.dtos;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.banktest.financial_api.domain.entities.Account;
import com.banktest.financial_api.domain.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String classId;

    @JsonProperty("Número da conta")
    private String accNumber;

    @JsonProperty("type")
    private AccountType type;

    @JsonProperty("Saldo")
    private Double balance;

    public AccountDTO() {
}


    public AccountDTO(Account account){
        this.accNumber = account.getAccNumber();
        this.type = account.getType();
        this.balance = account.getBalance();
    }


    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    

}
