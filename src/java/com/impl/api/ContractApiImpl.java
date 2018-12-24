package com.impl.api;

import com.api.ContractApi;
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
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.service.ContractService;
import com.util.UtilHelper;
import com.validator.contract.ContractRequestValidator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.BeanParam;
import java.util.List;

@RestController
public class ContractApiImpl implements ContractApi {

    private final UtilHelper utilHelper;
    private final ContractRequestValidator contractRequestValidator;
    private final ContractService contractService;

    public ContractApiImpl(
            UtilHelper utilHelper,
            ContractRequestValidator contractRequestValidator,
            ContractService contractService) {
        this.utilHelper = utilHelper;
        this.contractRequestValidator = contractRequestValidator;
        this.contractService = contractService;
    }


    @Override
    public VehicleContractResponseDto createVehicleContract(@RequestBody CreateVehicleContractDto createVehicleContractDto) {
        contractRequestValidator.validate(createVehicleContractDto);
        return contractService.createVehicleContract(createVehicleContractDto);
    }

    @Override
    public LifeContractResponseDto createLifeContract(@RequestBody CreateLifeContractDto createLifeContractDto) {
        contractRequestValidator.validate(createLifeContractDto);
        return contractService.createLifeContract(createLifeContractDto);
    }

    @Override
    public PropertyContractResponseDto createPropertyContract(@RequestBody CreatePropertyContractDto createPropertyContractDto) {
        contractRequestValidator.validate(createPropertyContractDto);
        return contractService.createPropertyContract(createPropertyContractDto);
    }

    @Override
    public MobileContractResponseDto createMobileContract(@RequestBody CreateMobileContractDto createMobileContractDto) {
        contractRequestValidator.validate(createMobileContractDto);
        return contractService.createMobileContract(createMobileContractDto);
    }

    @Override
    public VehicleContractResponseDto updateVehicleContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateVehicleContractDto updateVehicleContractDto) {
        contractRequestValidator.validate(updateVehicleContractDto);
        return contractService.updateVehicleContract(contractId, updateVehicleContractDto);
    }

    @Override
    public LifeContractResponseDto updateLifeContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateLifeContractDto updateLifeContractDto) {
        contractRequestValidator.validate(updateLifeContractDto);
        return contractService.updateLifeContract(contractId, updateLifeContractDto);
    }

    @Override
    public PropertyContractResponseDto updatePropertyContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdatePropertyContractDto updatePropertyContractDto) {
        contractRequestValidator.validate(updatePropertyContractDto);
        return contractService.updatePropertyContract(contractId, updatePropertyContractDto);
    }

    @Override
    public MobileContractResponseDto updateMobileContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateMobileContractDto updateMobileContractDto) {
        contractRequestValidator.validate(updateMobileContractDto);
        return contractService.updateMobileContract(contractId, updateMobileContractDto);
    }

    @Override
    public List<ContractResponseDto> getContractsOfUser(@BeanParam ContractCriteria contractCriteria) {
        return contractService.getContractsOfUser(contractCriteria);
    }

    @Override
    public List<ContractResponseDto> getContractsByExpiryDate(@RequestParam("client-id") Long clientId) {
        validatePositiveNumber(clientId);
        return contractService.getContractsByExpiryDate(clientId);
    }

    @Override
    public List<ContractResponseDto> getContractsByCompensationAmount(@RequestParam("client-id") Long clientId) {
        validatePositiveNumber(clientId);
        return contractService.getContractsByCompensationAmount(clientId);
    }

    @Override
    public List<ContractResponseDto> getExpiredContracts(@RequestParam("number-of-contracts") Integer numberOfContracts, @RequestParam("next-days") Integer nextDays) {
        validatePositiveNumber(numberOfContracts);
        validatePositiveNumber(nextDays);
        return contractService.getExpiredContracts(numberOfContracts, nextDays);
    }

    private void validatePositiveNumber(Number number) {
        if (!utilHelper.isPositivevNumber(number)) {
            throw new ContractException(ContractError.INVALID_DATA);
        }

    }
}
