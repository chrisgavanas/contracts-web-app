package com.validator.contract;

import com.dto.request.contract.CreateContractDto;
import com.util.FieldsValidator;
import com.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public abstract class CreateContractRequestValidator implements Validator<CreateContractDto> {

    @Autowired
    protected FieldsValidator fieldsValidator;

    @Override
    public void validate(CreateContractDto createContractDto) {
        validateBaseContract(createContractDto);
    }

    private void validateBaseContract(CreateContractDto createContractDto) {
        if (createContractDto == null) {
            throw new RuntimeException();
        }

        validateAllFieldsArePresent(createContractDto);
        validateDateRange(createContractDto.getEffectiveDate(), createContractDto.getExpirationDate());
        validateAmount(createContractDto.getPremiumAmount());
    }

    private void validateAllFieldsArePresent(CreateContractDto createContractDto) {
        boolean anyNull = fieldsValidator.anyNull(
                createContractDto.getEffectiveDate(),
                createContractDto.getExpirationDate(),
                createContractDto.getPremiumAmount(),
                createContractDto.getClientId()
        );

        if (anyNull) {
            throw new RuntimeException();
        }
    }

    private void validateDateRange(Instant effectiveDate, Instant expirationDate) {
        if (effectiveDate.isAfter(expirationDate)) {
            throw new RuntimeException();
        }
    }

    protected void validateAmount(Double premiumAmount) {
        if (premiumAmount <= 0) {
            throw new RuntimeException();
        }
    }

}
