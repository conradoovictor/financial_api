package com.banktest.financial_api.domain.dtos.AccountDTO;

import jakarta.validation.constraints.NotNull;

import com.banktest.financial_api.domain.enums.AccountType;

public class AccountRequestDTO {

    @NotNull(message = "clientId é obrigatório")
    private Integer clientId;

    @NotNull(message = "Tipo da conta é obrigatório")
    private AccountType type;

    public AccountRequestDTO() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
