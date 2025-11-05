package com.banktest.financial_api.domain.entities;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.banktest.financial_api.domain.enums.AccountType;

@Document(value = "transactions")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String accOrigin;
    private String accDestiny;
    private Double value;
    private AccountType type;
    private Instant moment;

    public Transaction() {
    }

    public Transaction(String id, String accOrigin, String accDestiny, Double value, AccountType type, Instant moment) {
        this.id = id;
        this.accOrigin = accOrigin;
        this.accDestiny = accDestiny;
        this.value = value;
        this.type = type;
        this.moment = moment;
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

    public String getAccOrigin() {
        return accOrigin;
    }

    public void setAccOrigin(String accOrigin) {
        this.accOrigin = accOrigin;
    }

    public String getAccDestiny() {
        return accDestiny;
    }

    public void setAccDestiny(String accDestiny) {
        this.accDestiny = accDestiny;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
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
        Transaction other = (Transaction) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
