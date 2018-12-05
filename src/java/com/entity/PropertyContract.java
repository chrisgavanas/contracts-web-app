package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property_contract")
public class PropertyContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_contract_id")
    private Long propertyContractId;

    @Column(name = "construction_year")
    private Integer constructionYear;

    @Column(name = "objective_value")
    private Double objectiveValue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public Long getPropertyContractId() {
        return propertyContractId;
    }

    public void setPropertyContractId(Long propertyContractId) {
        this.propertyContractId = propertyContractId;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Double getObjectiveValue() {
        return objectiveValue;
    }

    public void setObjectiveValue(Double objectiveValue) {
        this.objectiveValue = objectiveValue;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}