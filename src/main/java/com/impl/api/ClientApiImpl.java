package com.impl.api;

import com.api.ClientApi;
import com.entity.Contract;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientApiImpl implements ClientApi {

    @Override
    public Contract getContractsOfClient(@RequestParam("client-id") Long clientId) {
        System.out.println(clientId);
        return null;
    }
}
