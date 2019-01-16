package com.validator.contract.life;

import com.dto.request.contract.life.UpdateLifeContractDto;
import com.validator.contract.UpdateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class UpdateLifeContractRequestValidator extends UpdateContractRequestValidator {

    public void validate(UpdateLifeContractDto updateLifeContractDto) {
        super.validate(updateLifeContractDto);
        validateAmount(updateLifeContractDto.getInsuredValue());
    }

}
