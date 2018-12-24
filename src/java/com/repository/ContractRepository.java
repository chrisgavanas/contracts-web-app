package com.repository;

import com.entity.Client;
import com.entity.Contract;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long>, JpaSpecificationExecutor<Contract> {

    List<Contract> findAll(Specification<Contract> specification);

    List<Contract> findAllByClientOrderByExpirationDate(Client client);

    List<Contract> findAllByClientOrderByPremiumAmount(Client client);

    List<Contract> findAllByExpirationDateBefore(Instant instant, Pageable pageable);

}
