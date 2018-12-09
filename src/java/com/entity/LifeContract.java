package com.entity;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "life_contract")
public class LifeContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "life_contract_id")
    private Long lifeContractId;

    @Column(name = "secured_age")
    private Integer securedAge;

    @Column(name = "beneficiary")
    private String beneficiary;

    @Enumerated(EnumType.STRING)
    @Column(name = "medical_record")
    private MedicalRecord medicalRecord;

    @Column(name = "insured_value")
    private Double insuredValue;

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public Long getLifeContractId() {
        return lifeContractId;
    }

    public void setLifeContractId(Long lifeContractId) {
        this.lifeContractId = lifeContractId;
    }

    public Integer getSecuredAge() {
        return securedAge;
    }

    public void setSecuredAge(Integer securedAge) {
        this.securedAge = securedAge;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medical_record) {
        this.medicalRecord = medical_record;
    }

    public Double getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(Double insuredValue) {
        this.insuredValue = insuredValue;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}

