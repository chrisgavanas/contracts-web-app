package com.dao;

import com.entity.Contract;
import com.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractDao {

    @Autowired
    private ContractRepository contractRepository;

}
