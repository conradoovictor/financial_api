
package com.banktest.financial_api.domain.dtos.AccountDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DepositRequestDTO {

    @NotBlank
    private String accNumber;

    @NotNull
    @Positive
    private Double value;

    public String getAccNumber() {
        return accNumber;
    }

    public Double getValue() {
        return value;
    }
}
