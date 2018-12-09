package com.api;

import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.life.LifeContractResponseDto;
import com.dto.response.vehicle.VehicleContractResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api")
public interface ContractApi {

    @PostMapping(path = "/vehicle-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto);

    @PostMapping(path = "/life-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto);

    @PostMapping(path = "/vehicle-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto);

}
