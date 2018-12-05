package com.repository;

import com.entity.VehicleContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleContractRepository extends CrudRepository<VehicleContract, Long> {
}
