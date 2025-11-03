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

    public Client findById(String id){
        Optional<Client> obj = repo.findById(id);
            return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Client insert (Client obj){
        Optional<Client> uniqueCPF = repo.findByCpf(obj.getCpf());
        if(uniqueCPF.isPresent()){
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        return repo.save(obj);
    }

    public void delete (String id){
        findById(id);
        repo.deleteById(id);
    }
}
