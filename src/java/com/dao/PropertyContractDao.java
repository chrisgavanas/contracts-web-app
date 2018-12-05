package com.dao;

import com.repository.PropertyContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyContractDao {

    @Autowired
    private PropertyContractRepository propertyContractRepository;

}
