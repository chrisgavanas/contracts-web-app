package com.validator.contract.property;

import com.dto.enums.ContractType;
import com.dto.request.contract.property.CreatePropertyContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.validator.contract.CreateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class CreatePropertyContractRequestValidator extends CreateContractRequestValidator {

    @Override
    protected void validateContractType(ContractType contractType) {
        if (ContractType.PROPERTY != contractType) {
            throw new ContractException(ContractError.INVALID_CONTRACT_TYPE);
        }
    }

    public void validate(CreatePropertyContractDto createPropertyContractDto) {
        super.validate(createPropertyContractDto);
        validateAllFieldsArePresent(createPropertyContractDto);
        validateAmount(createPropertyContractDto.getObjectiveValue());
        validateYear(createPropertyContractDto.getConstructionYear());
    }


    private void validateAllFieldsArePresent(CreatePropertyContractDto createPropertyContractDto) {
        boolean anyNull = utilHelper.anyNull(
                createPropertyContractDto.getConstructionYear(),
                createPropertyContractDto.getObjectiveValue(),
                createPropertyContractDto.getRegistryNumber()
        );

        if (anyNull) {
            throw new ContractException(ContractError.MISSING_DATA);
        }
    }

    private void validateYear(Integer year) {
        if (utilHelper.invalidAllowedYearForProperties(year)) {
            throw new ContractException(ContractError.INVALID_YEAR_RANGE);
        }
    }

}