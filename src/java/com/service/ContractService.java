package com.service;

import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.request.contract.mobile.CreateMobileContractDto;
import com.dto.request.contract.mobile.UpdateMobileContractDto;
import com.dto.request.contract.property.CreatePropertyContractDto;
import com.dto.request.contract.property.UpdatePropertyContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.contract.life.LifeContractResponseDto;
import com.dto.response.contract.mobile.MobileContractResponseDto;
import com.dto.response.contract.property.PropertyContractResponseDto;
import com.dto.response.contract.vehicle.VehicleContractResponseDto;

public interface ContractService {

    VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto);

    LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto);

    PropertyContractResponseDto createPropertyContract(CreatePropertyContractDto createPropertyContractDto);

    MobileContractResponseDto createMobileContract(CreateMobileContractDto createMobileContractDto);

    VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto);

    LifeContractResponseDto updateLifeContract(Long contractId, UpdateLifeContractDto updateLifeContractDto);

    PropertyContractResponseDto updatePropertyContract(Long contractId, UpdatePropertyContractDto updatePropertyContractDto);

    MobileContractResponseDto updateMobileContract(Long contractId, UpdateMobileContractDto updateMobileContractDto);

}
