package com.dto.request.contract.vehicle;

import com.dto.request.contract.UpdateContractDto;

public class UpdateVehicleContractDto extends UpdateContractDto {

    private String plateNumber;

    private Integer bonusMalus;

    private Integer firstRegistrationYear;

    private Double vehicleValue;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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
