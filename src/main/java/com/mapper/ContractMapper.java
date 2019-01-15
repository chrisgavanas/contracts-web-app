package com.mapper;

import com.dto.request.contract.CreateContractDto;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.mobile.CreateMobileContractDto;
import com.dto.request.contract.property.CreatePropertyContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.response.contract.ContractResponseDto;
import com.dto.response.contract.life.LifeContractResponseDto;
import com.dto.response.contract.mobile.MobileContractResponseDto;
import com.dto.response.contract.property.PropertyContractResponseDto;
import com.dto.response.contract.vehicle.VehicleContractResponseDto;
import com.entity.Client;
import com.entity.Contract;
import com.entity.ContractType;
import com.entity.LifeContract;
import com.entity.MedicalRecord;
import com.entity.MobileContract;
import com.entity.PropertyContract;
import com.entity.VehicleContract;
import com.gateway.CompensationResponseDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContractMapper {

    public VehicleContract createVehicleContractDtoToEntity(CreateVehicleContractDto createVehicleContractDto, CompensationResponseDto compensationResponseDto, Client client) {
        if (createVehicleContractDto == null) {
            return null;
        }
        VehicleContract vehicleContract = new VehicleContract();        // TODO Builder pattern
        vehicleContract.setPlateNumber(createVehicleContractDto.getPlateNumber());
        vehicleContract.setBonusMalus(createVehicleContractDto.getBonusMalus());
        vehicleContract.setFirstRegistrationYear(createVehicleContractDto.getFirstRegistrationYear());
        vehicleContract.setVehicleValue(createVehicleContractDto.getVehicleValue());
        vehicleContract.setCompensation(compensationResponseDto.getCompensation());
        enrichBaseContract(vehicleContract, createVehicleContractDto, client, compensationResponseDto.getPremiumAmount());
        return vehicleContract;
    }

    public LifeContract createLifeContractDtoToEntity(CreateLifeContractDto createLifeContractDto, Client client, CompensationResponseDto compensationResponseDto) {
        if (createLifeContractDto == null) {
            return null;
        }

        LifeContract lifeContract = new LifeContract();
        lifeContract.setSecuredAge(createLifeContractDto.getSecuredAge());
        lifeContract.setBeneficiary(createLifeContractDto.getBeneficiary());
        lifeContract.setMedicalRecord(MedicalRecord.valueOf(createLifeContractDto.getMedicalRecord().toString()));
        lifeContract.setInsuredValue(createLifeContractDto.getInsuredValue());
        lifeContract.setCompensation(compensationResponseDto.getCompensation());
        enrichBaseContract(lifeContract, createLifeContractDto, client, compensationResponseDto.getPremiumAmount());
        return lifeContract;
    }

    public PropertyContract createPropertyContractDtoToEntity(CreatePropertyContractDto createPropertyContractDto, Client client, CompensationResponseDto compensationResponseDto) {
        if (createPropertyContractDto == null) {
            return null;
        }

        PropertyContract propertyContract = new PropertyContract();
        propertyContract.setConstructionYear(createPropertyContractDto.getConstructionYear());
        propertyContract.setObjectiveValue(createPropertyContractDto.getObjectiveValue());
        propertyContract.setRegistryNumber(createPropertyContractDto.getRegistryNumber());
        propertyContract.setCompensation(compensationResponseDto.getCompensation());
        enrichBaseContract(propertyContract, createPropertyContractDto, client, compensationResponseDto.getPremiumAmount());
        return propertyContract;
    }

    public MobileContract createMobileContractDtoToEntity(CreateMobileContractDto createMobileContractDto, Client client) {
        if (createMobileContractDto == null) {
            return null;
        }

        MobileContract mobileContract = new MobileContract();
        mobileContract.setImei(createMobileContractDto.getImei());
        mobileContract.setModel(createMobileContractDto.getModel());
        mobileContract.setType(createMobileContractDto.getType());
        enrichBaseContract(mobileContract, createMobileContractDto, client, null);
        return mobileContract;
    }

    public VehicleContractResponseDto vehicleContractToResponseDto(VehicleContract vehicleContract) {
        if (vehicleContract == null) {
            return null;
        }

        VehicleContractResponseDto vehicleContractResponseDto = new VehicleContractResponseDto();
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
        lifeContractResponseDto.setSecuredAge(lifeContract.getSecuredAge());
        lifeContractResponseDto.setBeneficiary(lifeContract.getBeneficiary());
        lifeContractResponseDto.setMedicalRecord(com.dto.enums.MedicalRecord.valueOf(lifeContract.getMedicalRecord().toString()));
        lifeContractResponseDto.setInsuredValue(lifeContract.getInsuredValue());
        enrichBaseContract(lifeContractResponseDto, lifeContract);
        return lifeContractResponseDto;
    }

    public PropertyContractResponseDto propertyContractToResponseDto(PropertyContract propertyContract) {
        if (propertyContract == null) {
            return null;
        }

        PropertyContractResponseDto propertyContractResponseDto = new PropertyContractResponseDto();
        propertyContractResponseDto.setConstructionYear(propertyContract.getConstructionYear());
        propertyContractResponseDto.setRegistryNumber(propertyContract.getRegistryNumber());
        propertyContractResponseDto.setObjectiveValue(propertyContract.getObjectiveValue());
        enrichBaseContract(propertyContractResponseDto, propertyContract);
        return propertyContractResponseDto;
    }

    public MobileContractResponseDto mobileContractToResponseDto(MobileContract mobileContract) {
        if (mobileContract == null) {
            return null;
        }

        MobileContractResponseDto mobileContractResponseDto = new MobileContractResponseDto();
        mobileContractResponseDto.setImei(mobileContract.getImei());
        mobileContractResponseDto.setModel(mobileContract.getModel());
        mobileContractResponseDto.setType(mobileContract.getType());
        enrichBaseContract(mobileContractResponseDto, mobileContract);
        return mobileContractResponseDto;
    }

    public List<ContractResponseDto> contractsToResponseDto(List<Contract> contracts) {
        if (contracts == null) {
            return Collections.emptyList();
        }

        return contracts.stream().map(contract -> {
            switch (contract.getContractType()) {
                case LIFE:
                    return lifeContractToResponseDto((LifeContract) contract);
                case MOBILE:
                    return mobileContractToResponseDto((MobileContract) contract);
                case VEHICLE:
                    return vehicleContractToResponseDto((VehicleContract) contract);
                case PROPERTY:
                    return propertyContractToResponseDto((PropertyContract) contract);
                default:
                    return null;
            }
        }).collect(Collectors.toList());
    }

    private void enrichBaseContract(Contract contract, CreateContractDto createContractDto, Client client, Double premiumAmout) {
        contract.setEffectiveDate(createContractDto.getEffectiveDate());
        contract.setPremiumAmount(premiumAmout);
        contract.setExpirationDate(createContractDto.getExpirationDate());
        contract.setClient(client);
        contract.setContractType(ContractType.valueOf(createContractDto.getContractType().toString()));
    }

    private void enrichBaseContract(ContractResponseDto contractResponseDto, Contract baseContract) {
        contractResponseDto.setContractId(baseContract.getContractId());
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
