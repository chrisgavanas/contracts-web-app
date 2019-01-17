package com.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.response.contract.ContractResponseDto;

@RequestMapping(path = "/api")
public interface ClientApi {

    @GetMapping(path = "/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getContractsOfClient(Long clientId);

}
