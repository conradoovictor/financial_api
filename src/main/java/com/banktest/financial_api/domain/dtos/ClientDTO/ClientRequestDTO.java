package com.banktest.financial_api.domain.dtos.ClientDTO;

import java.time.LocalDate;

import com.banktest.financial_api.domain.entities.Client;

public class ClientRequestDTO {

    private String name;
    private String cpf;
    private LocalDate birthDate;

    public ClientRequestDTO() {
    }

    public Client toEntity() {
        Client client = new Client();
        client.setClientName(this.name);
        client.setClientCpf(this.cpf);
        client.setBirthDate(this.birthDate);
        return client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}