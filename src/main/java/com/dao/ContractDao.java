package com.dao;

import com.entity.Client;
import com.entity.Contract;
import com.entity.ContractType;
import com.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Component
public class ContractDao {

    @Autowired
    private ContractRepository contractRepository;

    public Optional<Contract> findContractByContractId(Long contractId) {
        return contractRepository.findById(contractId);
    }

    public List<Contract> findAllBasedOnCriteria(Long clientId, Long contractId, ContractType contractType) {
        Specification<Contract> specification = Specification
                .where(clientIdEquals(clientId))
                .and(contractIdEquals(contractId))
                .and(contractTypeEquals(contractType));

        return contractRepository.findAll(specification);
    }

    public List<Contract> findAllByClientIdOrderedByExpirationDate(Client client) {
        return contractRepository.findAllByClientOrderByExpirationDate(client);
    }

    public List<Contract> findAllByClientIdOrderedByCompensationAmount(Client client) {
        return contractRepository.findAllByClientOrderByPremiumAmount(client);
    }

    public List<Contract> findTopExpiredContracts(Integer numberOfContracts, Integer nextDays) {
        Instant now = Instant.now().plus(nextDays, ChronoUnit.DAYS);
        PageRequest pageRequest = PageRequest.of(0, numberOfContracts);
        return contractRepository.findAllByExpirationDateBefore(now, pageRequest);
    }

    private Specification<Contract> clientIdEquals(Long clientId) {
        return (root, query, builder) -> {
            if (clientId != null) {
                return builder.equal(root.get("client"), clientId);
            }
            return builder.conjunction();
        };
    }

    private Specification<Contract> contractIdEquals(Long contractId) {
        return (root, query, builder) -> {
            if (contractId != null) {
                return builder.equal(root.get("contractId"), contractId);
            }
            return builder.conjunction();
        };
    }

    private Specification<Contract> contractTypeEquals(ContractType contractType) {
        return (root, query, builder) -> {
            if (contractType != null) {
                return builder.equal(root.get("contractType"), contractType);
            }
            return builder.conjunction();
        };
    }

}
