package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "property_contract")
public class PropertyContract extends Contract {

    @Column(name = "construction_year")
    private Integer constructionYear;

    @Column(name = "objective_value")
    private Double objectiveValue;

    @Column(name = "registry_number")
    private String registryNumber;

    @Column(name = "compensation")
    private Double compensation;

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

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public Double getCompensation() {
        return compensation;
    }

    public void setCompensation(Double compensation) {
        this.compensation = compensation;
    }
}