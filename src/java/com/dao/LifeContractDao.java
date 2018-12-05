package com.dao;

import com.repository.LifeContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LifeContractDao {

    @Autowired
    private LifeContractRepository lifeContractRepository;

}
