package com.banktest.financial_api.domain.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.banktest.financial_api.domain.enums.AccountType;

@Document(value = "accounts")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String classId;

    private Integer clientId;
    private String accNumber;
    private AccountType type;
    private Double balance;

    public Account() {
    }

    public Account(Integer clientId, String accNumber, AccountType type, Double balance) {
        this.clientId = clientId;
        this.accNumber = accNumber;
        this.type = type;
        this.balance = balance;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((classId == null) ? 0 : classId.hashCode());
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
        if (classId == null) {
            if (other.classId != null)
                return false;
        } else if (!classId.equals(other.classId))
            return false;
        return true;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}