package com.service;

import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.life.LifeContractResponseDto;
import com.dto.response.vehicle.VehicleContractResponseDto;

public interface ContractService {

    VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto);

    LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto);

    VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto);

    LifeContractResponseDto updateLifeContract(Long contractId, UpdateLifeContractDto updateLifeContractDto);
}
