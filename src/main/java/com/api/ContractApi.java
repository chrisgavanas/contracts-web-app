package com.api;

import com.dto.request.contract.ContractCriteria;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.request.contract.mobile.CreateMobileContractDto;
import com.dto.request.contract.mobile.UpdateMobileContractDto;
import com.dto.request.contract.property.CreatePropertyContractDto;
import com.dto.request.contract.property.UpdatePropertyContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.contract.ContractResponseDto;
import com.dto.response.contract.life.LifeContractResponseDto;
import com.dto.response.contract.mobile.MobileContractResponseDto;
import com.dto.response.contract.property.PropertyContractResponseDto;
import com.dto.response.contract.vehicle.VehicleContractResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api")
public interface ContractApi {

    @PostMapping(path = "/admin/vehicle-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto);

    @PostMapping(path = "/admin/life-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto);

    @PostMapping(path = "/admin/property-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PropertyContractResponseDto createPropertyContract(CreatePropertyContractDto createPropertyContractDto);

    @PostMapping(path = "/admin/mobile-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MobileContractResponseDto createMobileContract(CreateMobileContractDto createMobileContractDto);

    @PostMapping(path = "/admin/vehicle-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto);

    @PostMapping(path = "/admin/life-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LifeContractResponseDto updateLifeContract(Long contractId, UpdateLifeContractDto lifeContractDto);

    @PostMapping(path = "/admin/property-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PropertyContractResponseDto updatePropertyContract(Long contractId, UpdatePropertyContractDto updatePropertyContractDto);

    @PostMapping(path = "/admin/mobile-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MobileContractResponseDto updateMobileContract(Long contractId, UpdateMobileContractDto updateMobileContractDto);

    @GetMapping(path = "/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getContractsOfUser(ContractCriteria contractCriteria);

    @GetMapping(path = "/admin/contracts-by-expiration-date", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getContractsByExpiryDate(Long clientId);

    @GetMapping(path = "/admin/contracts-by-compensation-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getContractsByCompensationAmount(Long clientId);

    @GetMapping(path = "/admin/contract/{contract-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ContractResponseDto getContractById(Long contractId);

    @GetMapping(path = "/admin/expired-contracts-next-days", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getExpiredContracts(Integer numberOfContracts, Integer nextDays);

}
