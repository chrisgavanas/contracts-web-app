package com.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Contract;

@RequestMapping(path = "/api")
public interface ClientApi {

    @GetMapping(path = "/contract", produces = MediaType.APPLICATION_JSON_VALUE)
    Contract getContractsOfClient(@RequestParam("client-id") Long clientId);

}
