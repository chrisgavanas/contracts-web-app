package com.impl.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.ClientApi;
import com.dto.response.client.ClientResponseDto;
import com.dto.response.contract.ContractResponseDto;
import com.service.ClientService;
import com.service.ContractService;

@RestController
public class ClientApiImpl implements ClientApi {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContractService contractService;

    @Override
    public List<ContractResponseDto> getContractsOfClient(@RequestParam("client-id") Long clientId) {
        ClientResponseDto clientResponseDto = clientService.findUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return contractService.getContractsOfUser(null, clientResponseDto.getClientId());
    }
}
