package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "life_contract")
public class LifeContract extends Contract {

    @Column(name = "secured_age")
    private Integer securedAge;

    @Column(name = "beneficiary")
    private String beneficiary;

    @Enumerated(EnumType.STRING)
    @Column(name = "medical_record")
    private MedicalRecord medicalRecord;

    @Column(name = "insured_value", precision = 10, scale = 2)
    private Double insuredValue;

    @Column(name = "compensation")
    private Double compensation;

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

    public Double getCompensation() {
        return compensation;
    }

    public void setCompensation(Double compensation) {
        this.compensation = compensation;
    }
}

