package com.validator.contract.mobile;

import com.dto.request.contract.mobile.UpdateMobileContractDto;
import com.validator.contract.UpdateContractRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class UpdateMobileContractRequestValidator extends UpdateContractRequestValidator {

    public void validate(UpdateMobileContractDto updateMobileContractDto) {
        super.validate(updateMobileContractDto);
    }

}