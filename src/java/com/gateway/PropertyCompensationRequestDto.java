package com.gateway;

import java.time.Instant;

public class PropertyCompensationRequestDto {

    private Instant constructionYear;

    private Double objectiveValue;

    public Instant getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Instant constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Double getObjectiveValue() {
        return objectiveValue;
    }

    public void setObjectiveValue(Double objectiveValue) {
        this.objectiveValue = objectiveValue;
    }
}
