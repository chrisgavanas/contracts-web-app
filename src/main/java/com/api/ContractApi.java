package com.api;

import java.util.List;

import javax.ws.rs.BeanParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

@RequestMapping(path = "/api")
public interface ContractApi {

    @PostMapping(path = "/admin/vehicle-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto createVehicleContract(@RequestBody CreateVehicleContractDto createVehicleContractDto);

    @PostMapping(path = "/admin/life-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LifeContractResponseDto createLifeContract(@RequestBody CreateLifeContractDto createLifeContractDto);

    @PostMapping(path = "/admin/property-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PropertyContractResponseDto createPropertyContract(@RequestBody CreatePropertyContractDto createPropertyContractDto);

    @PostMapping(path = "/admin/mobile-contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MobileContractResponseDto createMobileContract(@RequestBody CreateMobileContractDto createMobileContractDto);

    @PostMapping(path = "/admin/vehicle-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleContractResponseDto updateVehicleContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateVehicleContractDto updateVehicleContractDto);

    @PostMapping(path = "/admin/life-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LifeContractResponseDto updateLifeContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateLifeContractDto lifeContractDto);

    @PostMapping(path = "/admin/property-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PropertyContractResponseDto updatePropertyContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdatePropertyContractDto updatePropertyContractDto);

    @PostMapping(path = "/admin/mobile-contract/{contract-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MobileContractResponseDto updateMobileContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateMobileContractDto updateMobileContractDto);

    @GetMapping(path = "/admin/user-contracts", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getContractsOfUser(@BeanParam ContractCriteria contractCriteria);

    @GetMapping(path = "/admin/contracts-by-expiration-date", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getContractsByExpiryDate(@RequestParam("client-id") Long clientId);

    @GetMapping(path = "/admin/contracts-by-compensation-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getContractsByCompensationAmount(@RequestParam("client-id") Long clientId);

    @GetMapping(path = "/admin/expired-contracts-next-days", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponseDto> getExpiredContracts(@RequestParam("client-id") Integer numberOfContracts, @RequestParam("next-days") Integer nextDays);

}
