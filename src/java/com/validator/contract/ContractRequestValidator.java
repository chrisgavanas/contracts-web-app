package com.validator.contract;

import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.request.contract.mobile.CreateMobileContractDto;
import com.dto.request.contract.mobile.UpdateMobileContractDto;
import com.dto.request.contract.property.CreatePropertyContractDto;
import com.dto.request.contract.property.UpdatePropertyContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.validator.contract.life.CreateLifeContractRequestValidator;
import com.validator.contract.life.UpdateLifeContractRequestValidator;
import com.validator.contract.mobile.CreateMobileContractRequestValidator;
import com.validator.contract.mobile.UpdateMobileContractRequestValidator;
import com.validator.contract.property.CreatePropertyContractRequestValidator;
import com.validator.contract.property.UpdatePropertyContractRequestValidator;
import com.validator.contract.vehicle.CreateVehicleContractRequestValidator;
import com.validator.contract.vehicle.UpdateVehicleContractRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractRequestValidator {

    private final CreateVehicleContractRequestValidator createVehicleContractRequestValidator;
    private final CreateLifeContractRequestValidator createLifeContractRequestValidator;
    private final CreatePropertyContractRequestValidator createPropertyContractRequestValidator;
    private final CreateMobileContractRequestValidator createMobileContractRequestValidator;
    private final UpdateVehicleContractRequestValidator updateVehicleContractRequestValidator;
    private final UpdateLifeContractRequestValidator updateLifeContractRequestValidator;
    private final UpdatePropertyContractRequestValidator updatePropertyContractRequestValidator;
    private final UpdateMobileContractRequestValidator updateMobileContractRequestValidator;

    @Autowired
    public ContractRequestValidator(
            CreateVehicleContractRequestValidator createVehicleContractRequestValidator,
            CreateLifeContractRequestValidator createLifeContractRequestValidator,
            CreatePropertyContractRequestValidator createPropertyContractRequestValidator,
            CreateMobileContractRequestValidator createMobileContractRequestValidator,
            UpdateVehicleContractRequestValidator updateVehicleContractRequestValidator,
            UpdateLifeContractRequestValidator updateLifeContractRequestValidator,
            UpdatePropertyContractRequestValidator updatePropertyContractRequestValidator,
            UpdateMobileContractRequestValidator updateMobileContractRequestValidator) {

        this.createVehicleContractRequestValidator = createVehicleContractRequestValidator;
        this.createLifeContractRequestValidator = createLifeContractRequestValidator;
        this.createPropertyContractRequestValidator = createPropertyContractRequestValidator;
        this.createMobileContractRequestValidator = createMobileContractRequestValidator;
        this.updateVehicleContractRequestValidator = updateVehicleContractRequestValidator;
        this.updateLifeContractRequestValidator = updateLifeContractRequestValidator;
        this.updatePropertyContractRequestValidator = updatePropertyContractRequestValidator;
        this.updateMobileContractRequestValidator = updateMobileContractRequestValidator;
    }

    public void validate(CreateVehicleContractDto createVehicleContractDto) {
        createVehicleContractRequestValidator.validate(createVehicleContractDto);
    }

    public void validate(CreateLifeContractDto createLifeContractDto) {
        createLifeContractRequestValidator.validate(createLifeContractDto);
    }

    public void validate(CreatePropertyContractDto createPropertyContractDto) {
        createPropertyContractRequestValidator.validate(createPropertyContractDto);
    }

    public void validate(CreateMobileContractDto createMobileContractDto) {
        createMobileContractRequestValidator.validate(createMobileContractDto);
    }

    public void validate(UpdateVehicleContractDto updateVehicleContractDto) {
        updateVehicleContractRequestValidator.validate(updateVehicleContractDto);
    }

    public void validate(UpdateLifeContractDto updateLifeContractDto) {
        updateLifeContractRequestValidator.validate(updateLifeContractDto);
    }

    public void validate(UpdatePropertyContractDto updatePropertyContractDto) {
        updatePropertyContractRequestValidator.validate(updatePropertyContractDto);
    }

    public void validate(UpdateMobileContractDto updateMobileContractDto) {
        updateMobileContractRequestValidator.validate(updateMobileContractDto);
    }

}
