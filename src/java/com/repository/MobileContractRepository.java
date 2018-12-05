package com.repository;

import com.entity.MobileContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileContractRepository extends CrudRepository<MobileContract, Long> {
}
