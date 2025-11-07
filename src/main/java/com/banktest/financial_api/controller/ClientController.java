package com.banktest.financial_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.banktest.financial_api.domain.dtos.ClientDTO;
import com.banktest.financial_api.domain.entities.Client;
import com.banktest.financial_api.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<ClientDTO> list = service.findAll().stream().map(ClientDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Client objClient) {
        Client client = service.insert(objClient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getClientId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "{clientId}", method = RequestMethod.GET)
    public ResponseEntity<ClientDTO> findByClientId(@PathVariable Integer clientId) {
        Client obj = service.findByClientId(clientId);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> delete(@PathVariable Integer clientId) {
        service.delete(clientId);
        return ResponseEntity.noContent().build();
    }

}