package com.api;

import com.dto.request.contract.mobile.CreateMobileContractDto;
import com.dto.request.contract.mobile.UpdateMobileContractDto;
import com.dto.request.contract.property.CreatePropertyContractDto;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.property.UpdatePropertyContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.contract.life.LifeContractResponseDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.response.contract.mobile.MobileContractResponseDto;
import com.dto.response.contract.property.PropertyContractResponseDto;
import com.dto.response.contract.vehicle.VehicleContractResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api")
public interface ContractApi {

    @PostMapping(path = "/vehicle-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto);

    @PostMapping(path = "/life-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto);

    @PostMapping(path = "/property-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PropertyContractResponseDto createPropertyContract(CreatePropertyContractDto createPropertyContractDto);

    @PostMapping(path = "/mobile-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MobileContractResponseDto createMobileContract(CreateMobileContractDto createMobileContractDto);

    @PostMapping(path = "/vehicle-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto);

    @PostMapping(path = "/life-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LifeContractResponseDto updateLifeContract(Long contractId, UpdateLifeContractDto lifeContractDto);

    @PostMapping(path = "/property-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PropertyContractResponseDto updatePropertyContract(Long contractId, UpdatePropertyContractDto updatePropertyContractDto);

    @PostMapping(path = "/mobile-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MobileContractResponseDto updateMobileContract(Long contractId, UpdateMobileContractDto updateMobileContractDto);

}
