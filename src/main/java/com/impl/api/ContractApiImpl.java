package com.impl.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

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
    public VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto) {
        contractRequestValidator.validate(createVehicleContractDto);
        return contractService.createVehicleContract(createVehicleContractDto);
    }

    @Override
    public LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto) {
        contractRequestValidator.validate(createLifeContractDto);
        return contractService.createLifeContract(createLifeContractDto);
    }

    @Override
    public PropertyContractResponseDto createPropertyContract(CreatePropertyContractDto createPropertyContractDto) {
        contractRequestValidator.validate(createPropertyContractDto);
        return contractService.createPropertyContract(createPropertyContractDto);
    }

    @Override
    public MobileContractResponseDto createMobileContract(CreateMobileContractDto createMobileContractDto) {
        contractRequestValidator.validate(createMobileContractDto);
        return contractService.createMobileContract(createMobileContractDto);
    }

    @Override
    public VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto) {
        contractRequestValidator.validate(updateVehicleContractDto);
        return contractService.updateVehicleContract(contractId, updateVehicleContractDto);
    }

    @Override
    public LifeContractResponseDto updateLifeContract(Long contractId, UpdateLifeContractDto updateLifeContractDto) {
        contractRequestValidator.validate(updateLifeContractDto);
        return contractService.updateLifeContract(contractId, updateLifeContractDto);
    }

    @Override
    public PropertyContractResponseDto updatePropertyContract(Long contractId, UpdatePropertyContractDto updatePropertyContractDto) {
        contractRequestValidator.validate(updatePropertyContractDto);
        return contractService.updatePropertyContract(contractId, updatePropertyContractDto);
    }

    @Override
    public MobileContractResponseDto updateMobileContract(Long contractId, UpdateMobileContractDto updateMobileContractDto) {
        contractRequestValidator.validate(updateMobileContractDto);
        return contractService.updateMobileContract(contractId, updateMobileContractDto);
    }

    @Override
    public List<ContractResponseDto> getContractsOfUser(ContractCriteria contractCriteria) {
        return contractService.getContractsOfUser(contractCriteria);
    }

    @Override
    public List<ContractResponseDto> getContractsByExpiryDate(Long clientId) {
        validatePositiveNumber(clientId);
        return contractService.getContractsByExpiryDate(clientId);
    }

    @Override
    public List<ContractResponseDto> getContractsByCompensationAmount(Long clientId) {
        validatePositiveNumber(clientId);
        return contractService.getContractsByCompensationAmount(clientId);
    }

    @Override
    public List<ContractResponseDto> getExpiredContracts(Integer numberOfContracts, Integer nextDays) {
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
