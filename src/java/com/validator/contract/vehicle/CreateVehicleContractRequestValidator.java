package com.validator.contract.vehicle;

import com.dto.enums.ContractType;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.validator.contract.CreateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class CreateVehicleContractRequestValidator extends CreateContractRequestValidator {

    @Override
    protected void validateContractType(ContractType contractType) {
        if (ContractType.VEHICLE != contractType) {
            throw new ContractException(ContractError.INVALID_CONTRACT_TYPE);
        }
    }

    public void validate(CreateVehicleContractDto createVehicleContractDto) {
        super.validate(createVehicleContractDto);
        validateAllFieldsArePresent(createVehicleContractDto);
        validateBonusMalus(createVehicleContractDto.getBonusMalus());
        validateAmount(createVehicleContractDto.getVehicleValue());
        validatePlateNumber(createVehicleContractDto.getPlateNumber());
    }

    private void validatePlateNumber(String plateNumber) {
        if (utilHelper.invalidVehiclePlateFormat(plateNumber)) {
            throw new ContractException(ContractError.INVALID_PLATE_NUMBER_FORMAT);
        }
    }

    private void validateAllFieldsArePresent(CreateVehicleContractDto createVehicleContractDto) {
        boolean anyNull = utilHelper.anyNull(
                createVehicleContractDto.getPlateNumber(),
                createVehicleContractDto.getBonusMalus(),
                createVehicleContractDto.getFirstRegistrationYear(),
                createVehicleContractDto.getVehicleValue()
        );

        if (anyNull) {
            throw new ContractException(ContractError.MISSING_DATA);
        }
    }

    private void validateBonusMalus(Integer bonusMalus) {
        if (utilHelper.valueOutOfRange(bonusMalus)) {
            throw new ContractException(ContractError.BONUS_MALUS_OUT_OF_RANGE);
        }
    }

}
