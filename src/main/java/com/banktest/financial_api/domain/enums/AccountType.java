package com.banktest.financial_api.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AccountType {

    CORRENTE,
    POUPANCA;

    @JsonCreator
    public static AccountType fromString(String value) {
        return value == null ? null : AccountType.valueOf(value.toUpperCase());
    }

}
