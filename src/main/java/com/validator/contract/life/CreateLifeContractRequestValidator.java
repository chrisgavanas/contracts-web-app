package com.validator.contract.life;

import com.dto.enums.ContractType;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.validator.contract.CreateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class CreateLifeContractRequestValidator extends CreateContractRequestValidator {

    @Override
    protected void validateContractType(ContractType contractType) {
        if (ContractType.LIFE != contractType) {
            throw new ContractException(ContractError.INVALID_CONTRACT_TYPE);
        }
    }

    public void validate(CreateLifeContractDto createLifeContractDto) {
        super.validate(createLifeContractDto);
        validateAllFieldsArePresent(createLifeContractDto);
        validateAmount(createLifeContractDto.getInsuredValue());
    }

    private void validateAllFieldsArePresent(CreateLifeContractDto createLifeContractDto) {
        boolean anyNull = utilHelper.anyNull(
                createLifeContractDto.getSecuredAge(),
                createLifeContractDto.getBeneficiary(),
                createLifeContractDto.getMedicalRecord(),
                createLifeContractDto.getInsuredValue()
        );

        if (anyNull) {
            throw new ContractException(ContractError.MISSING_DATA);
        }
    }

}
