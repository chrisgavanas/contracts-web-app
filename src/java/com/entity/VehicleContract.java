package com.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_contract")
public class VehicleContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_contract_id")
    private Long vehicleContractId;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "bonus_malus")
    private Integer bonusMalus;

    @Column(name = "first_registration_year")
    private Integer firstRegistrationYear;

    @Column(name = "vehicle_value")
    private Double vehicleValue;

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public Long getVehicleContractId() {
        return vehicleContractId;
    }

    public void setVehicleContractId(Long vehicleContractId) {
        this.vehicleContractId = vehicleContractId;
    }

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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}