package com.validator.contract.property;

import com.dto.request.contract.property.UpdatePropertyContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.validator.contract.UpdateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class UpdatePropertyContractRequestValidator extends UpdateContractRequestValidator {

    public void validate(UpdatePropertyContractDto updatePropertyContractDto) {
        super.validate(updatePropertyContractDto);
        validateAmount(updatePropertyContractDto.getObjectiveValue());
        validateYear(updatePropertyContractDto.getConstructionYear());
    }

    private void validateYear(Integer year) {
        if (year != null && utilHelper.invalidAllowedYearForProperties(year)) {
            throw new ContractException(ContractError.INVALID_YEAR_RANGE);
        }
    }

}