package com.api;

import com.entity.Contract;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api")
public interface ClientApi {

    @GetMapping(path = "/contract", produces = MediaType.APPLICATION_JSON_VALUE)
    Contract getContractsOfClient(Long clientId);

}
