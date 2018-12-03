package com.api;

import com.entity.Contract;
import com.repository.ClientRepository;
import com.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ClientApi {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(path = "/test", method = RequestMethod.POST, produces = "application/json")
    public Contract test() {
        return null;
    }

}
