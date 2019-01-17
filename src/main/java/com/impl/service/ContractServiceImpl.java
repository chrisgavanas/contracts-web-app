package com.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ClientDao;
import com.dao.ContractDao;
import com.dao.LifeContractDao;
import com.dao.MobileContractDao;
import com.dao.PropertyContractDao;
import com.dao.VehicleContractDao;
import com.dto.enums.ContractType;
import com.dto.request.contract.ContractCriteria;
import com.dto.request.contract.UpdateContractDto;
import com.dto.request.contract.life.CreateLifeContractDto;
import com.dto.request.contract.life.UpdateLifeContractDto;
import com.dto.request.contract.mobile.CreateMobileContractDto;
import com.dto.request.contract.mobile.UpdateMobileContractDto;
import com.dto.request.contract.property.CreatePropertyContractDto;
import com.dto.request.contract.property.UpdatePropertyContractDto;
import com.dto.request.contract.vehicle.CreateVehicleContractDto;
import com.dto.request.contract.vehicle.UpdateVehicleContractDto;
import com.dto.response.contract.ContractResponseDto;
import com.dto.response.contract.life.LifeContractResponseDto;
import com.dto.response.contract.mobile.MobileContractResponseDto;
import com.dto.response.contract.property.PropertyContractResponseDto;
import com.dto.response.contract.vehicle.VehicleContractResponseDto;
import com.entity.Client;
import com.entity.Contract;
import com.entity.LifeContract;
import com.entity.MobileContract;
import com.entity.PropertyContract;
import com.entity.VehicleContract;
import com.entity.enums.MedicalRecord;
import com.entity.enums.MobileDeviceModel;
import com.entity.enums.MobileDeviceType;
import com.error.ClientError;
import com.error.ContractError;
import com.exception.NotFoundException;
import com.exception.contract.ContractException;
import com.gateway.CompensationResponseDto;
import com.gateway.IacsGateway;
import com.mapper.ContractMapper;
import com.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private VehicleContractDao vehicleContractDao;

    @Autowired
    private LifeContractDao lifeContractDao;

    @Autowired
    private PropertyContractDao propertyContractDao;

    @Autowired
    private MobileContractDao mobileContractDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private IacsGateway iacsGateway;

    @Override
    public VehicleContractResponseDto createVehicleContract(CreateVehicleContractDto createVehicleContractDto) {
        Client client = findClientByClientId(createVehicleContractDto.getClientId());

        CompensationResponseDto vehicleCompensation = iacsGateway.calculateVehicleCompensation(
                createVehicleContractDto.getBonusMalus(),
                createVehicleContractDto.getFirstRegistrationYear(),
                createVehicleContractDto.getVehicleValue()
        );

        VehicleContract vehicleContract = contractMapper.createVehicleContractDtoToEntity(createVehicleContractDto, vehicleCompensation, client);
        vehicleContract = vehicleContractDao.persistVehicleContract(vehicleContract);

        return contractMapper.vehicleContractToResponseDto(vehicleContract);
    }

    @Override
    public LifeContractResponseDto createLifeContract(CreateLifeContractDto createLifeContractDto) {
        Client client = findClientByClientId(createLifeContractDto.getClientId());

        CompensationResponseDto lifeCompensation = iacsGateway.calculateLifeCompensation(
                createLifeContractDto.getSecuredAge(),
                createLifeContractDto.getMedicalRecord(),
                createLifeContractDto.getInsuredValue()
        );

        LifeContract lifeContract = contractMapper.createLifeContractDtoToEntity(createLifeContractDto, client, lifeCompensation);
        lifeContract = lifeContractDao.persistLifeContract(lifeContract);

        return contractMapper.lifeContractToResponseDto(lifeContract);
    }

    @Override
    public PropertyContractResponseDto createPropertyContract(CreatePropertyContractDto createPropertyContractDto) {
        Client client = findClientByClientId(createPropertyContractDto.getClientId());

        CompensationResponseDto lifeCompensation = iacsGateway.calculatePropertyCompensation(
                createPropertyContractDto.getConstructionYear(),
                createPropertyContractDto.getObjectiveValue()
        );

        PropertyContract propertyContract = contractMapper.createPropertyContractDtoToEntity(createPropertyContractDto, client, lifeCompensation);
        propertyContract = propertyContractDao.persistPropertyContract(propertyContract);

        return contractMapper.propertyContractToResponseDto(propertyContract);
    }

    @Override
    public MobileContractResponseDto createMobileContract(CreateMobileContractDto createMobileContractDto) {
        Client client = findClientByClientId(createMobileContractDto.getClientId());

        MobileContract mobileContract = contractMapper.createMobileContractDtoToEntity(createMobileContractDto, client);
        mobileContract = mobileContractDao.persistMobileContract(mobileContract);

        return contractMapper.mobileContractToResponseDto(mobileContract);
    }

    @Transactional
    @Override
    public VehicleContractResponseDto updateVehicleContract(Long contractId, UpdateVehicleContractDto updateVehicleContractDto) {
        VehicleContract vehicleContract = findVehicleContractById(contractId);
        updateVehicleContractFields(vehicleContract, updateVehicleContractDto);
        return contractMapper.vehicleContractToResponseDto(vehicleContract);
    }

    @Transactional
    @Override
    public LifeContractResponseDto updateLifeContract(Long contractId, UpdateLifeContractDto updateLifeContractDto) {
        LifeContract lifeContract = findLifeContractById(contractId);
        updateLifeContractFields(lifeContract, updateLifeContractDto);
        return contractMapper.lifeContractToResponseDto(lifeContract);
    }

    @Transactional
    @Override
    public PropertyContractResponseDto updatePropertyContract(Long contractId, UpdatePropertyContractDto updatePropertyContractDto) {
        PropertyContract propertyContract = findPropertyContractById(contractId);
        updatePropertyContractFields(propertyContract, updatePropertyContractDto);
        return contractMapper.propertyContractToResponseDto(propertyContract);
    }

    @Transactional
    @Override
    public MobileContractResponseDto updateMobileContract(Long contractId, UpdateMobileContractDto updateMobileContractDto) {
        MobileContract mobileContract = findMobileContractById(contractId);
        updateMobileContractFields(mobileContract, updateMobileContractDto);
        return contractMapper.mobileContractToResponseDto(mobileContract);
    }

    @Override
    public List<ContractResponseDto> getContractsOfUser(ContractCriteria contractCriteria, Long clientId) {
        List<Contract> contracts = contractDao.findAllBasedOnCriteria(
                clientId,
                contractCriteria.getContractId(),
                convertToDomain(contractCriteria.getContractType())
        );
        return contractMapper.contractsToResponseDto(contracts);
    }

    @Override
    public List<ContractResponseDto> getContractsByExpiryDate(Long clientId) {
        Client client = findClientByClientId(clientId);
        List<Contract> contracts = contractDao.findAllByClientIdOrderedByExpirationDate(client);
        return contractMapper.contractsToResponseDto(contracts);
    }

    @Override
    public List<ContractResponseDto> getContractsByCompensationAmount(Long clientId) {
        Client client = findClientByClientId(clientId);
        List<Contract> contracts = contractDao.findAllByClientIdOrderedByCompensationAmount(client);
        return contractMapper.contractsToResponseDto(contracts);
    }

    @Override
    public List<ContractResponseDto> getExpiredContracts(Integer numberOfContracts, Integer nextDays) {
        List<Contract> contracts = contractDao.findTopExpiredContracts(numberOfContracts, nextDays);
        return contractMapper.contractsToResponseDto(contracts);
    }

    private VehicleContract findVehicleContractById(Long contractId) {
        return vehicleContractDao.findVehicleContractById(contractId)
                .orElseThrow(() -> new NotFoundException(ContractError.CONTRACT_NOT_FOUND));
    }

    private LifeContract findLifeContractById(Long contractId) {
        return lifeContractDao.findLifeContractById(contractId)
                .orElseThrow(() -> new NotFoundException(ContractError.CONTRACT_NOT_FOUND));
    }

    private PropertyContract findPropertyContractById(Long contractId) {
        return propertyContractDao.findLifeContractById(contractId)
                .orElseThrow(() -> new NotFoundException(ContractError.CONTRACT_NOT_FOUND));
    }

    private MobileContract findMobileContractById(Long contractId) {
        return mobileContractDao.findMobileContractById(contractId)
                .orElseThrow(() -> new NotFoundException(ContractError.CONTRACT_NOT_FOUND));
    }

    private Client findClientByClientId(Long clientId) {
        return clientDao.findClientByClientId(clientId)
                .orElseThrow(() -> new NotFoundException(ClientError.CLIENT_NOT_FOUND));
    }


    private void updateVehicleContractFields(VehicleContract vehicleContract, UpdateVehicleContractDto updateVehicleContractDto) {
        Optional.ofNullable(updateVehicleContractDto.getBonusMalus()).ifPresent(vehicleContract::setBonusMalus);
        Optional.ofNullable(updateVehicleContractDto.getPlateNumber()).ifPresent(vehicleContract::setPlateNumber);
        Optional.ofNullable(updateVehicleContractDto.getVehicleValue()).ifPresent(vehicleContract::setVehicleValue);
        Optional.ofNullable(updateVehicleContractDto.getFirstRegistrationYear()).ifPresent(vehicleContract::setFirstRegistrationYear);
        updateBaseContractFields(vehicleContract, updateVehicleContractDto);
    }

    private void updateLifeContractFields(LifeContract lifeContract, UpdateLifeContractDto updateLifeContractDto) {
        Optional.ofNullable(updateLifeContractDto.getSecuredAge()).ifPresent(lifeContract::setSecuredAge);
        Optional.ofNullable(updateLifeContractDto.getBeneficiary()).ifPresent(lifeContract::setBeneficiary);
        Optional.ofNullable(updateLifeContractDto.getMedicalRecord()).ifPresent(medicalRecord -> lifeContract.setMedicalRecord(MedicalRecord.valueOf(medicalRecord.name())));
        Optional.ofNullable(updateLifeContractDto.getInsuredValue()).ifPresent(lifeContract::setInsuredValue);
        updateBaseContractFields(lifeContract, updateLifeContractDto);
    }

    private void updatePropertyContractFields(PropertyContract propertyContract, UpdatePropertyContractDto updatePropertyContractDto) {
        Optional.ofNullable(updatePropertyContractDto.getConstructionYear()).ifPresent(propertyContract::setConstructionYear);
        Optional.ofNullable(updatePropertyContractDto.getObjectiveValue()).ifPresent(propertyContract::setObjectiveValue);
        Optional.ofNullable(updatePropertyContractDto.getRegistryNumber()).ifPresent(propertyContract::setNationalRegistryNumber);
        updateBaseContractFields(propertyContract, updatePropertyContractDto);
    }


    private void updateMobileContractFields(MobileContract mobileContract, UpdateMobileContractDto updateMobileContractDto) {
        Optional.ofNullable(updateMobileContractDto.getImei()).ifPresent(mobileContract::setImei);
        Optional.ofNullable(updateMobileContractDto.getModel()).ifPresent(model -> mobileContract.setModel(MobileDeviceModel.valueOf(model)));
        Optional.ofNullable(updateMobileContractDto.getType()).ifPresent(model -> mobileContract.setType(MobileDeviceType.valueOf(model)));
        updateBaseContractFields(mobileContract, updateMobileContractDto);
    }

    private void updateBaseContractFields(Contract contract, UpdateContractDto updateContractDto) {
        if (contract != null) {
            Optional.ofNullable(updateContractDto.getEffectiveDate()).ifPresent(contract::setEffectiveDate);
            Optional.ofNullable(updateContractDto.getExpirationDate()).ifPresent(contract::setExpirationDate);
            Optional.ofNullable(updateContractDto.getPremiumAmount()).ifPresent(contract::setPremiumAmount);
            ensureContractDatesValidity(contract);
        }
    }

    private void ensureContractDatesValidity(Contract contract) {
        if (contract.getEffectiveDate().isAfter(contract.getExpirationDate())) {
            throw new ContractException(ContractError.EFFECTIVE_DATE_AFTER_EXPIRATION_DATE);
        }
    }

    private com.entity.enums.ContractType convertToDomain(ContractType contractType) {
        if (contractType == null) {
            return null;
        }
        return com.entity.enums.ContractType.valueOf(contractType.toString());
    }

}
