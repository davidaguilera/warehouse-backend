package com.warehouse.backend.service;

import com.warehouse.backend.dao.ClientRepository;
import com.warehouse.backend.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> createClients(List<Client> clients){
        return clientRepository.saveAll(clients);
    }

    public Client getClient(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client){
        Client oldClient = null;
        Optional<Client> optionalClient = clientRepository.findById(client.getClient_id());
        if(optionalClient.isPresent()){
            oldClient = optionalClient.get();
            oldClient.setName(client.getName());
            oldClient.setAddress(client.getAddress());
            oldClient.setRfc(client.getRfc());
            oldClient.setPhone_number(client.getPhone_number());
            oldClient.setEmail(client.getEmail());
            oldClient.setContact_email_address(client.getContact_email_address());
            oldClient.setContact_name(client.getContact_name());
            oldClient.setContact_name_phone(client.getContact_name_phone());
            clientRepository.save(oldClient);
        }else{
            return new Client();
        }
        return oldClient;
    }

    public String deleteClientById(int id){
        clientRepository.deleteById(id);
        return "User deleted";
    }
}
