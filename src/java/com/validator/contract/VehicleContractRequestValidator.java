package com.validator.contract;

import com.dto.request.contract.CreateVehicleContractDto;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class VehicleContractRequestValidator extends CreateContractRequestValidator {

    private static final String PLATE_NUMBER_FORMAT = "[ABEHIKMNOPTXYZ]{3}-[0123456789]{4}";
    private final Pattern pattern = Pattern.compile(PLATE_NUMBER_FORMAT);

    public void validate(CreateVehicleContractDto createVehicleContractDto) {
        super.validate(createVehicleContractDto);
        validateAllFieldsArePresent(createVehicleContractDto);
        validateAmount(createVehicleContractDto.getBonusMalus());
        validateAmount(createVehicleContractDto.getVehicleValue());
        validatePlateNumber(createVehicleContractDto.getPlateNumber());
    }

    private void validatePlateNumber(String plateNumber) {
        if (!pattern.matcher(plateNumber).matches()) {
            throw new RuntimeException();
        }
    }

    private void validateAllFieldsArePresent(CreateVehicleContractDto createVehicleContractDto) {
        boolean anyNull = fieldsValidator.anyNull(
                createVehicleContractDto.getPlateNumber(),
                createVehicleContractDto.getBonusMalus(),
                createVehicleContractDto.getFirstRegistrationDate(),
                createVehicleContractDto.getVehicleValue()
        );

        if (anyNull) {
            throw new RuntimeException();
        }
    }


}
