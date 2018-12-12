package com.impl.api;

import com.api.ContractApi;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.life.LifeContractResponseDto;
import com.dto.response.vehicle.VehicleContractResponseDto;
import com.service.ContractService;
import com.validator.contract.life.CreateLifeContractRequestValidator;
import com.validator.contract.life.UpdateLifeContractRequestValidator;
import com.validator.contract.vehicle.CreateVehicleContractRequestValidator;
import com.validator.contract.vehicle.UpdateVehicleContractRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractApiImpl implements ContractApi {

    @Autowired
    private CreateVehicleContractRequestValidator createVehicleContractRequestValidator;

    @Autowired
    private CreateLifeContractRequestValidator createLifeContractRequestValidator;

    @Autowired
    private UpdateVehicleContractRequestValidator updateVehicleContractRequestValidator;

    @Autowired
    private UpdateLifeContractRequestValidator updateLifeContractRequestValidator;


    @Autowired
    private ContractService contractService;

    @Override
    public VehicleContractResponseDto createVehicleContract(@RequestBody CreateVehicleContractDto createVehicleContractDto) {
        createVehicleContractRequestValidator.validate(createVehicleContractDto);
        return contractService.createVehicleContract(createVehicleContractDto);
    }

    @Override
    public LifeContractResponseDto createLifeContract(@RequestBody CreateLifeContractDto createLifeContractDto) {
        createLifeContractRequestValidator.validate(createLifeContractDto);
        return contractService.createLifeContract(createLifeContractDto);
    }

    @Override
    public VehicleContractResponseDto updateVehicleContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateVehicleContractDto updateVehicleContractDto) {
        updateVehicleContractRequestValidator.validate(updateVehicleContractDto);
        return contractService.updateVehicleContract(contractId, updateVehicleContractDto);
    }

    @Override
    public LifeContractResponseDto updateLifeContract(@PathVariable("contract-id") Long contractId, @RequestBody UpdateLifeContractDto updateLifeContractDto) {
        updateLifeContractRequestValidator.validate(updateLifeContractDto);
        return contractService.updateLifeContract(contractId, updateLifeContractDto);
    }


}
