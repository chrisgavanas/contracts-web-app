package com.mapper;

import com.dto.request.contract.CreateContractDto;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.response.ContractResponseDto;
import com.dto.response.life.LifeContractResponseDto;
import com.dto.response.vehicle.VehicleContractResponseDto;
import com.entity.Client;
import com.entity.Contract;
import com.entity.ContractType;
import com.entity.LifeContract;
import com.entity.MedicalRecord;
import com.entity.VehicleContract;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper {

    public VehicleContract createVehicleContractDtoToEntity(CreateVehicleContractDto createVehicleContractDto, Client client) {
        if (createVehicleContractDto == null) {
            return null;
        }

        VehicleContract vehicleContract = new VehicleContract();
        vehicleContract.setPlateNumber(createVehicleContractDto.getPlateNumber());
        vehicleContract.setBonusMalus(createVehicleContractDto.getBonusMalus());
        vehicleContract.setFirstRegistrationYear(createVehicleContractDto.getFirstRegistrationYear());
        vehicleContract.setVehicleValue(createVehicleContractDto.getVehicleValue());
        enrichBaseContract(vehicleContract, createVehicleContractDto, client);
        return vehicleContract;
    }

    public LifeContract createLifeContractDtoToEntity(CreateLifeContractDto createLifeContractDto, Client client) {
        if (createLifeContractDto == null) {
            return null;
        }

        LifeContract lifeContract = new LifeContract();
        lifeContract.setSecuredAge(createLifeContractDto.getSecuredAge());
        lifeContract.setBeneficiary(createLifeContractDto.getBeneficiary());
        lifeContract.setMedicalRecord(MedicalRecord.valueOf(createLifeContractDto.getMedicalRecord().toString()));
        lifeContract.setInsuredValue(createLifeContractDto.getInsuredValue());
        enrichBaseContract(lifeContract, createLifeContractDto, client);
        return lifeContract;
    }


    public VehicleContractResponseDto vehicleContractToResponseDto(VehicleContract vehicleContract) {
        if (vehicleContract == null) {
            return null;
        }

        VehicleContractResponseDto vehicleContractResponseDto = new VehicleContractResponseDto();
        vehicleContractResponseDto.setContractId(vehicleContract.getContractId());
        vehicleContractResponseDto.setPlateNumber(vehicleContract.getPlateNumber());
        vehicleContractResponseDto.setBonusMalus(vehicleContract.getBonusMalus());
        vehicleContractResponseDto.setFirstRegistrationYear(vehicleContract.getFirstRegistrationYear());
        vehicleContractResponseDto.setVehicleValue(vehicleContract.getVehicleValue());
        enrichBaseContract(vehicleContractResponseDto, vehicleContract);
        return vehicleContractResponseDto;
    }

    public LifeContractResponseDto lifeContractToResponseDto(LifeContract lifeContract) {
        if (lifeContract == null) {
            return null;
        }

        LifeContractResponseDto lifeContractResponseDto = new LifeContractResponseDto();
        lifeContractResponseDto.setContractId(lifeContract.getContractId());
        lifeContractResponseDto.setSecuredAge(lifeContract.getSecuredAge());
        lifeContractResponseDto.setBeneficiary(lifeContract.getBeneficiary());
        lifeContractResponseDto.setMedicalRecord(com.dto.enums.MedicalRecord.valueOf(lifeContract.getMedicalRecord().toString()));
        lifeContractResponseDto.setInsuredValue(lifeContract.getInsuredValue());
        enrichBaseContract(lifeContractResponseDto, lifeContract);
        return lifeContractResponseDto;
    }

    private void enrichBaseContract(Contract contract, CreateContractDto createContractDto, Client client) {
        contract.setEffectiveDate(createContractDto.getEffectiveDate());
        contract.setExpirationDate(createContractDto.getExpirationDate());
        contract.setPremiumAmount(createContractDto.getPremiumAmount());
        contract.setClient(client);
        contract.setContractType(ContractType.valueOf(createContractDto.getContractType().toString()));
    }

    private void enrichBaseContract(ContractResponseDto contractResponseDto, Contract baseContract) {
        contractResponseDto.setEffectiveDate(baseContract.getEffectiveDate());
        contractResponseDto.setExpirationDate(baseContract.getExpirationDate());
        contractResponseDto.setPremiumAmount(baseContract.getPremiumAmount());
        contractResponseDto.setEffectiveDate(baseContract.getEffectiveDate());
        contractResponseDto.setContractType(
                com.dto.enums.ContractType.valueOf(baseContract.getContractType().toString())
        );
        Client client = baseContract.getClient();
        if (client != null) {
            contractResponseDto.setClientId(client.getClientId());
        }
    }

}
