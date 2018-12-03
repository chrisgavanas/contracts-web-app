package com.dao;

import com.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDao {

    @Autowired
    private ClientRepository clientRepository;

}
