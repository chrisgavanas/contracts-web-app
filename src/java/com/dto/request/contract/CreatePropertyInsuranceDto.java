package com.dto.request.contract;

public class CreatePropertyInsuranceDto extends CreateContractDto {

    private String registryNumber;

    private Integer constructionYear;

    private Double objectiveValue;

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
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
}
