package com.dao;

import com.repository.MobileContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MobileContractDao {

    @Autowired
    private MobileContractRepository mobileContractRepository;

}
