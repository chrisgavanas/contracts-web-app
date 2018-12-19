package com.dao;

import com.entity.MobileContract;
import com.repository.MobileContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MobileContractDao {

    @Autowired
    private MobileContractRepository mobileContractRepository;

    public MobileContract persistMobileContract(MobileContract mobileContract) {
        return mobileContractRepository.save(mobileContract);
    }

    public Optional<MobileContract> findMobileContractById(Long contractId) {
        return mobileContractRepository.findById(contractId);
    }

}
