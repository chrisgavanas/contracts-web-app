package com.dto.request.contract;

import com.dto.enums.ContractType;

import javax.ws.rs.QueryParam;

public class ContractCriteria {

    private Long contractId;

    private ContractType contractType;

    public Long getContractId() {
        return contractId;
    }

    @QueryParam("contractId")
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public ContractType getContractType() {
        return contractType;
    }

    @QueryParam("contractType")
    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
