package com.banktest.financial_api.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
