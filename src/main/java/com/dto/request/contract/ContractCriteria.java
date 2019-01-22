package com.dto.request.contract;

import com.dto.enums.ContractType;

import javax.ws.rs.QueryParam;

public class ContractCriteria {

    private Long contractId;

    private ContractType contractType;

    public Long getContractId() {
        return contractId;
    }

    @QueryParam("contract-id")
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public ContractType getContractType() {
        return contractType;
    }

    @QueryParam("contract-type")
    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
