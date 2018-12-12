package com.impl.service;

import com.dao.ClientDao;
import com.dao.LifeContractDao;
import com.dao.VehicleContractDao;
import com.dto.request.contract.UpdateContractDto;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.life.LifeContractResponseDto;
import com.dto.response.vehicle.VehicleContractResponseDto;
import com.entity.Client;
import com.entity.Contract;
import com.entity.LifeContract;
import com.entity.MedicalRecord;
import com.entity.VehicleContract;
import com.error.ClientError;
import com.error.ContractError;
import com.exception.NotFoundException;
import com.exception.contract.ContractException;
import com.mapper.ContractMapper;
import com.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private VehicleContractDao vehicleContractDao;

    @Autowired
    private LifeContractDao lifeContractDao;

    @Autowired
    private ClientDao clientDao;

    @Transactional
    @Override
    public VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto) {
        Client client = findClientByClientId(createVehicleContractDto.getClientId());

        VehicleContract vehicleContract = contractMapper.createVehicleContractDtoToEntity(createVehicleContractDto, client);
        vehicleContract = vehicleContractDao.persistVehicleContract(vehicleContract);

        return contractMapper.vehicleContractToResponseDto(vehicleContract);
    }

    @Transactional
    @Override
    public LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto) {
        Client client = findClientByClientId(createLifeContractDto.getClientId());

        LifeContract lifeContract = contractMapper.createLifeContractDtoToEntity(createLifeContractDto, client);
        lifeContract = lifeContractDao.persistLifeContract(lifeContract);

        return contractMapper.lifeContractToResponseDto(lifeContract);
    }

    @Override
    public VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto) {
        VehicleContract vehicleContract = findVehicleContractById(contractId);

        updateVehicleContractFields(vehicleContract, updateVehicleContractDto);
        ensureContractDatesValidity(vehicleContract.getContract());
        vehicleContractDao.persistVehicleContract(vehicleContract);

        return contractMapper.vehicleContractToResponseDto(vehicleContract);
    }

    @Transactional
    @Override
    public LifeContractResponseDto updateLifeContract(Long contractId, UpdateLifeContractDto updateLifeContractDto) {
        LifeContract lifeContract = findLifeContractById(contractId);

        updateLifeContractFields(lifeContract, updateLifeContractDto);
        ensureContractDatesValidity(lifeContract.getContract());
        lifeContractDao.persistLifeContract(lifeContract);

        return contractMapper.lifeContractToResponseDto(lifeContract);
    }

    private LifeContract findLifeContractById(Long contractId) {
        return lifeContractDao.findLifeContractById(contractId)
                .orElseThrow(() -> new NotFoundException(ContractError.CONTRACT_NOT_FOUND));
    }

    private Client findClientByClientId(Long clientId) {
        return clientDao.findClientByClientId(clientId)
                .orElseThrow(() -> new NotFoundException(ClientError.CLIENT_NOT_FOUND));
    }

    private VehicleContract findVehicleContractById(Long contractId) {
        return vehicleContractDao.findVehicleContractById(contractId)
                .orElseThrow(() -> new NotFoundException(ContractError.CONTRACT_NOT_FOUND));
    }

    private void ensureContractDatesValidity(Contract contract) {
        if (contract.getEffectiveDate().isAfter(contract.getExpirationDate())) {
            throw new ContractException(ContractError.EFFECTIVE_DATE_AFTER_EXPIRATION_DATE);
        }
    }

    private void updateVehicleContractFields(VehicleContract vehicleContract, UpdateVehicleContractDto updateVehicleContractDto) {
        Optional.ofNullable(updateVehicleContractDto.getBonusMalus()).ifPresent(vehicleContract::setBonusMalus);
        Optional.ofNullable(updateVehicleContractDto.getPlateNumber()).ifPresent(vehicleContract::setPlateNumber);
        Optional.ofNullable(updateVehicleContractDto.getVehicleValue()).ifPresent(vehicleContract::setVehicleValue);
        Optional.ofNullable(updateVehicleContractDto.getFirstRegistrationYear()).ifPresent(vehicleContract::setFirstRegistrationYear);
        updateBaseContractFields(vehicleContract.getContract(), updateVehicleContractDto);
    }

    private void updateLifeContractFields(LifeContract lifeContract, UpdateLifeContractDto updateLifeContractDto) {
        Optional.ofNullable(updateLifeContractDto.getSecuredAge()).ifPresent(lifeContract::setSecuredAge);
        Optional.ofNullable(updateLifeContractDto.getBeneficiary()).ifPresent(lifeContract::setBeneficiary);
        Optional.ofNullable(updateLifeContractDto.getMedicalRecord()).ifPresent(medicalRecord -> lifeContract.setMedicalRecord(MedicalRecord.valueOf(medicalRecord.name())));
        Optional.ofNullable(updateLifeContractDto.getInsuredValue()).ifPresent(lifeContract::setInsuredValue);
        updateBaseContractFields(lifeContract.getContract(), updateLifeContractDto);
    }

    private void updateBaseContractFields(Contract contract, UpdateContractDto updateContractDto) {
        if (contract != null) {
            Optional.ofNullable(updateContractDto.getEffectiveDate()).ifPresent(contract::setEffectiveDate);
            Optional.ofNullable(updateContractDto.getExpirationDate()).ifPresent(contract::setExpirationDate);
            Optional.ofNullable(updateContractDto.getPremiumAmount()).ifPresent(contract::setPremiumAmount);
        }
    }


}
