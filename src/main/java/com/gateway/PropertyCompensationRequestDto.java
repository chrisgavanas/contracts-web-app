package com.gateway;

import java.time.Instant;

public class PropertyCompensationRequestDto {

    private Integer constructionYear;

    private Double objectiveValue;

    public PropertyCompensationRequestDto(Integer constructionYear, Double objectiveValue) {
        this.constructionYear = constructionYear;
        this.objectiveValue = objectiveValue;
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
