package com.banktest.financial_api.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banktest.financial_api.domain.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = new ArrayList<>();
        Client maria = new Client("01", "Maria Silva", "00000000000", LocalDate.parse("1990-03-22"));
        Client joao = new Client("02", "João Silva", "00000000000", LocalDate.parse("1996-11-12"));
        list.addAll(Arrays.asList(maria, joao));
        return ResponseEntity.ok().body(list);

    }
}
