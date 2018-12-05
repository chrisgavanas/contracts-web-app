package com.api;

import com.dto.request.contract.CreateContractDto;
import com.dto.response.CreateContractResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api")
public interface ContractApi {

    @PostMapping(path = "/vehicle-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CreateContractResponseDto createVehicleContract(CreateContractDto createContractRequestDto);

}
