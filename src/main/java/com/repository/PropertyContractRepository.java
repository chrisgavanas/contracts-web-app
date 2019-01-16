package com.repository;

import com.entity.PropertyContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyContractRepository extends CrudRepository<PropertyContract, Long> {
}
