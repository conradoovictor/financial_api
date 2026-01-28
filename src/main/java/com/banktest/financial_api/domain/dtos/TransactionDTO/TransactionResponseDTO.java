package com.banktest.financial_api.domain.dtos.TransactionDTO;

import java.time.Instant;

import com.banktest.financial_api.domain.entities.Transaction;
import com.banktest.financial_api.domain.enums.TransactionType;

public class TransactionResponseDTO {

    private String id;
    private String accOrigin;
    private String accDestiny;
    private Double value;
    private TransactionType type;
    private Instant moment;

    public TransactionResponseDTO(Transaction tx) {
        this.id = tx.getId();
        this.accOrigin = tx.getAccOrigin();
        this.accDestiny = tx.getAccDestiny();
        this.value = tx.getValue();
        this.type = tx.getType();
        this.moment = tx.getMoment();
    }

    public String getId() {
        return id;
    }

    public String getAccOrigin() {
        return accOrigin;
    }

    public String getAccDestiny() {
        return accDestiny;
    }

    public Double getValue() {
        return value;
    }

    public TransactionType getType() {
        return type;
    }

    public Instant getMoment() {
        return moment;
    }
}
