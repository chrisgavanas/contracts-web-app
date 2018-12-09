package com.dao;

import com.entity.VehicleContract;
import com.repository.VehicleContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleContractDao {

    @Autowired
    private VehicleContractRepository vehicleContractRepository;

    public VehicleContract persistVehicleContract(VehicleContract vehicleContract) {
        return vehicleContractRepository.save(vehicleContract);
    }

    public Optional<VehicleContract> findVehicleContractById(Long vehicleContractId) {
        return vehicleContractRepository.findById(vehicleContractId);
    }

}
