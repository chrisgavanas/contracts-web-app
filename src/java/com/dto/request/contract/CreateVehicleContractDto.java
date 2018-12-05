package com.dto.request.contract;

public class CreateVehicleContractDto extends CreateContractDto {

    private String plateNumber;

    private Double bonusMalus;

    private Integer firstRegistrationDate;

    private Double vehicleValue;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Double getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(Double bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    public Integer getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Integer firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public Double getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(Double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

}
