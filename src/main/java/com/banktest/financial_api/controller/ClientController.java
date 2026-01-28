package com.banktest.financial_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.banktest.financial_api.domain.dtos.ClientDTO.ClientRequestDTO;
import com.banktest.financial_api.domain.dtos.ClientDTO.ClientResponseDTO;
import com.banktest.financial_api.domain.entities.Client;
import com.banktest.financial_api.services.ClientService;

@RestController
@RequestMapping(value = "/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        List<ClientResponseDTO> list = service.findAll().stream().map(ClientResponseDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientRequestDTO dto) {
        Client client = service.insert(dto.toEntity());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getClientId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponseDTO> findByClientId(@PathVariable Integer clientId) {
        Client obj = service.findByClientId(clientId);
        return ResponseEntity.ok().body(new ClientResponseDTO(obj));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Integer clientId) {
        service.delete(clientId);
        return ResponseEntity.noContent().build();
    }
}
