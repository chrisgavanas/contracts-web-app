package com.impl.api;

import org.springframework.web.bind.annotation.RestController;

import com.api.ClientApi;
import com.entity.Contract;

@RestController
public class ClientApiImpl implements ClientApi {

    @Override
    public Contract getContractsOfClient(Long clientId) {
        System.out.println(clientId);
        return null;
    }
}
