package com.dao;

import com.entity.LifeContract;
import com.repository.LifeContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LifeContractDao {

    @Autowired
    private LifeContractRepository lifeContractRepository;

    public LifeContract persistLifeContract(LifeContract lifeContract) {
        return lifeContractRepository.save(lifeContract);
    }

    public Optional<LifeContract> findLifeContractById(Long contractId) {
        return lifeContractRepository.findById(contractId);
    }

}
