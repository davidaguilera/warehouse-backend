package com.warehouse.backend.controller;

import com.warehouse.backend.entity.Client;
import com.warehouse.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client client){
        return clientService.createClient(client);
    }
}
