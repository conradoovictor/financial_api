package com.banktest.financial_api.domain.dtos.TransactionDTO;

public class TransactionRequestDTO {

    private String accOrigin;
    private String accDestiny;
    private Double value;

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
}
