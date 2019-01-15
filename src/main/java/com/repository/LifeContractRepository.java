package com.repository;

import com.entity.LifeContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifeContractRepository extends CrudRepository<LifeContract, Long> {
}
