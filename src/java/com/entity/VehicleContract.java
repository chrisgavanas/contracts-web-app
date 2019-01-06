package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_contract")
public class VehicleContract extends Contract {

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "bonus_malus")
    private Integer bonusMalus;

    @Column(name = "first_registration_year")
    private Integer firstRegistrationYear;

    @Column(name = "vehicle_value")
    private Double vehicleValue;

    @Column(name = "compensation")
    private Double compensation;

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

    public Double getCompensation() {
        return compensation;
    }

    public void setCompensation(Double compensation) {
        this.compensation = compensation;
    }

}