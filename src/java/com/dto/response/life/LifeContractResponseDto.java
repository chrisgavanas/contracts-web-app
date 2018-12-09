package com.dto.response.life;

import com.dto.enums.MedicalRecord;
import com.dto.response.ContractResponseDto;

public class LifeContractResponseDto extends ContractResponseDto {

    private Integer securedAge;

    private String beneficiary;

    private MedicalRecord medicalRecord;

    private Double insuredValue;

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

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Double getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(Double insuredValue) {
        this.insuredValue = insuredValue;
    }
}
