package com.impl.api;

import com.api.ContractApi;
import com.dto.request.contract.CreateContractDto;
import com.dto.response.CreateContractResponseDto;
import com.validator.contract.CreateContractRequestValidator;
import com.validator.contract.VehicleContractRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractApiImpl implements ContractApi {

    @Autowired
    private VehicleContractRequestValidator vehicleContractRequestValidator;

    public CreateContractResponseDto createVehicleContract(CreateContractDto createContractRequestDto) {
        vehicleContractRequestValidator.validate(createContractRequestDto);

        return null;
    }

}
