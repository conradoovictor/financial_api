package com.banktest.financial_api.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.banktest.financial_api.domain.entities.Client;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    @JsonProperty("classId")
    private String classId;

    @JsonProperty("ID do cliente")
    private Integer clientId;

    @JsonProperty("Nome do cliente")
    private String clientName;

    @JsonProperty("CPF do cliente")
    private String clientCpf;

    @JsonProperty("Data de nascimento")
    private LocalDate birthDate;

    public ClientDTO(Client client){
        this.classId = client.getClassId();
        this.clientId = client.getClientId();
        this.clientName = client.getClientName();
        this.clientCpf = client.getClientCpf();
        this.birthDate = client.getBirthDate();
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    

}
