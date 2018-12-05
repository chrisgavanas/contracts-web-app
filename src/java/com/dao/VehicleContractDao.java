package com.dao;

import com.repository.VehicleContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleContractDao {

    @Autowired
    private VehicleContractRepository vehicleContractRepository;

}
