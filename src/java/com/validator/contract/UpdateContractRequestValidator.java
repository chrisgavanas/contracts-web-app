package com.validator.contract;

import com.dto.request.contract.UpdateContractDto;
import com.error.ContractError;
import com.exception.contract.ContractException;
import com.util.UtilHelper;
import com.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public abstract class UpdateContractRequestValidator implements Validator<UpdateContractDto> {

    @Autowired
    protected UtilHelper utilHelper;

    @Override
    public void validate(UpdateContractDto updateContractDto) {
        if (updateContractDto == null) {
            throw new ContractException(ContractError.MISSING_DATA);
        }

        validateDateRange(updateContractDto.getEffectiveDate(), updateContractDto.getExpirationDate());
        validateAmount(updateContractDto.getPremiumAmount());
    }

    private void validateDateRange(Instant effectiveDate, Instant expirationDate) {
        if (effectiveDate != null && expirationDate != null) {
            if (effectiveDate.isAfter(expirationDate)) {
                throw new ContractException(ContractError.EFFECTIVE_DATE_AFTER_EXPIRATION_DATE);
            }
        }
    }

    protected void validateAmount(Double amount) {
        if (amount != null && utilHelper.invalidAmount(amount)) {
            throw new ContractException(ContractError.INVALID_DATA);
        }
    }

}
