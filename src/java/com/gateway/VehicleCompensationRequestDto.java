package com.gateway;

import java.time.Instant;

public class VehicleCompensationRequestDto {

    private Integer bonusMalus;

    private Integer firstRegistrationYear;

    private Double vehicleValue;

    public VehicleCompensationRequestDto(Integer bonusMalus, Integer firstRegistrationYear, Double vehicleValue) {
        this.bonusMalus = bonusMalus;
        this.firstRegistrationYear = firstRegistrationYear;
        this.vehicleValue = vehicleValue;
    }

    public Integer getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(Integer bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    public Integer getFirstRegistrationYear() {
        return firstRegistrationYear;
    }

    public void setFirstRegistrationYear(Integer firstRegistrationYear) {
        this.firstRegistrationYear = firstRegistrationYear;
    }

    public Double getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(Double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

}
