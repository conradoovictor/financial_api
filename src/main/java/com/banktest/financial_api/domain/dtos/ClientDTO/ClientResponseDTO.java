package com.banktest.financial_api.domain.dtos.ClientDTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.banktest.financial_api.domain.entities.Client;

public class ClientResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer clientId;
    private String name;
    private String cpf;
    private LocalDate birthDate;

    public ClientResponseDTO(Client client) {
        this.clientId = client.getClientId();
        this.name = client.getClientName();
        this.cpf = client.getClientCpf();
        this.birthDate = client.getBirthDate();
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}