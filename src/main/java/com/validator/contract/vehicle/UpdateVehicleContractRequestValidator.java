package com.validator.contract.vehicle;

import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.validator.contract.UpdateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class UpdateVehicleContractRequestValidator extends UpdateContractRequestValidator {

    public void validate(UpdateVehicleContractDto updateVehicleContractDto) {
        super.validate(updateVehicleContractDto);
        validatePlateNumber(updateVehicleContractDto.getPlateNumber());
        validateBonusMalus(updateVehicleContractDto.getBonusMalus());
        validateAmount(updateVehicleContractDto.getVehicleValue());
    }

    private void validatePlateNumber(String plateNumber) {
        if (plateNumber != null && utilHelper.invalidVehiclePlateFormat(plateNumber)) {
            throw new ContractException(ContractError.INVALID_PLATE_NUMBER_FORMAT);
        }
    }

    private void validateBonusMalus(Integer bonusMalus) {
        if (bonusMalus != null && utilHelper.valueOutOfRange(bonusMalus)) {
            throw new ContractException(ContractError.BONUS_MALUS_OUT_OF_RANGE);
        }
    }

}
