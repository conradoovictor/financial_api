package com.banktest.financial_api.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clients")

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String classId;

    @Indexed(unique = true)
    private Integer clientId;
    private String clientName;

    @Indexed(unique = true)
    private String clientCpf;
    private LocalDate birthDate;

    public Client(){
    }

    public Client(Integer clientId, String clientName, String clientCpf, LocalDate birthDate) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientCpf = clientCpf;
        this.birthDate = birthDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((classId == null) ? 0 : classId.hashCode());
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
        Client other = (Client) obj;
        if (classId == null) {
            if (other.classId != null)
                return false;
        } else if (!classId.equals(other.classId))
            return false;
        return true;
    }

    
}