package com.validator.contract;

import com.dto.enums.ContractType;
import com.dto.request.contract.CreateContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.util.UtilHelper;
import com.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public abstract class CreateContractRequestValidator implements Validator<CreateContractDto> {

    @Autowired
    protected UtilHelper utilHelper;

    @Override
    public void validate(CreateContractDto createContractDto) {
        validateBaseContract(createContractDto);
    }

    protected abstract void validateContractType(ContractType contractType);

    private void validateBaseContract(CreateContractDto createContractDto) {
        if (createContractDto == null) {
            throw new ContractException(ContractError.MISSING_DATA);
        }

        validateContractType(createContractDto.getContractType());
        validateAllFieldsArePresent(createContractDto);
        validateDateRange(createContractDto.getEffectiveDate(), createContractDto.getExpirationDate());
        validateAmount(createContractDto.getPremiumAmount());
    }

    private void validateAllFieldsArePresent(CreateContractDto createContractDto) {
        boolean anyNull = utilHelper.anyNull(
                createContractDto.getEffectiveDate(),
                createContractDto.getExpirationDate(),
                createContractDto.getPremiumAmount(),
                createContractDto.getClientId(),
                createContractDto.getContractType()
        );

        if (anyNull) {
            throw new ContractException(ContractError.MISSING_DATA);
        }
    }

    private void validateDateRange(Instant effectiveDate, Instant expirationDate) {
        if (effectiveDate.isAfter(expirationDate)) {
            throw new ContractException(ContractError.EFFECTIVE_DATE_AFTER_EXPIRATION_DATE);
        }
    }

    protected void validateAmount(Double amount) {
        if (utilHelper.invalidAmount(amount)) {
            throw new ContractException(ContractError.INVALID_YEAR_RANGE);
        }
    }

}
