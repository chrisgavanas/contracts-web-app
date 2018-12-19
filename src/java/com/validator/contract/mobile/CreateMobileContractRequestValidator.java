package com.validator.contract.mobile;

import com.dto.enums.ContractType;
import com.dto.request.contract.mobile.CreateMobileContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.validator.contract.CreateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class CreateMobileContractRequestValidator extends CreateContractRequestValidator {

    @Override
    protected void validateContractType(ContractType contractType) {
        if (ContractType.MOBILE != contractType) {
            throw new ContractException(ContractError.INVALID_CONTRACT_TYPE);
        }
    }

    public void validate(CreateMobileContractDto createMobileContractDto) {
        super.validate(createMobileContractDto);
        validateAllFieldsArePresent(createMobileContractDto);
    }


    private void validateAllFieldsArePresent(CreateMobileContractDto createMobileContractDto) {
        boolean anyNull = utilHelper.anyNull(
                createMobileContractDto.getImei(),
                createMobileContractDto.getModel(),
                createMobileContractDto.getType()
        );

        if (anyNull) {
            throw new ContractException(ContractError.MISSING_DATA);
        }
    }

}