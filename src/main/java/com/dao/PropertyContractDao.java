package com.dao;

import com.entity.PropertyContract;
import com.repository.PropertyContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PropertyContractDao {

    @Autowired
    private PropertyContractRepository propertyContractRepository;

    public PropertyContract persistPropertyContract(PropertyContract propertyContract) {
        return propertyContractRepository.save(propertyContract);
    }

    public Optional<PropertyContract> findLifeContractById(Long contractId) {
        return propertyContractRepository.findById(contractId);
    }

}
