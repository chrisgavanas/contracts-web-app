package com.dao;

import com.entity.LifeContract;
import com.repository.LifeContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LifeContractDao {

    @Autowired
    private LifeContractRepository lifeContractRepository;

    public LifeContract persistLifeContract(LifeContract lifeContract) {
        return lifeContractRepository.save(lifeContract);
    }
}
