package com.dao;

import com.entity.Client;
import com.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientDao {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> findClientByClientId(Long clientId) {
        return clientRepository.findById(clientId);
    }


}
