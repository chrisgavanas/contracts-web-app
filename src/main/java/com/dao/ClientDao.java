package com.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Client;
import com.repository.ClientRepository;

@Component
public class ClientDao {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> findClientByClientId(Long clientId) {
        return clientRepository.findById(clientId);
    }

    public Optional<Client> findClientByUsername(String username) {return clientRepository.findByUsername(username);}


}
