package com.banktest.financial_api.domain.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.banktest.financial_api.domain.enums.AccountType;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String accountNumber;
    private AccountType type;
    private Double balance;
    private String clientId;

    public Account() {
    }

    public Account(String id, String accountNumber, AccountType type, Double balance, String clientId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
        this.clientId = clientId;
    }

        public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
