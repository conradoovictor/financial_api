package com.banktest.financial_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banktest.financial_api.domain.entities.Client;
import com.banktest.financial_api.repositories.ClientRepository;
import com.banktest.financial_api.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public List<Client> findAll() {
        return repo.findAll();
    }

    public Client findByClientId(Integer clientId) {
        Optional<Client> obj = repo.findByClientId(clientId);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
    }

    public Client insert(Client obj) {
        Optional<Client> uniqueCPF = repo.findByClientCpf(obj.getClientCpf());
        if (uniqueCPF.isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        if (obj.getClientId() == null) {
            Integer nextId = generateClientId();
            obj.setClientId(nextId);
        }
        return repo.save(obj);
    }

    public Integer generateClientId() {
        return repo.findAll().stream().map(Client::getClientId).filter(id -> id != null).max(Integer::compareTo)
                .map(id -> id + 100).orElse(1);
    }

     public void delete(Integer clientId) {
        findByClientId(clientId);
        repo.deleteByClientId(clientId);
    }
}