package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "vehicle_contract")
public class VehicleContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_contract_id")
    private Long vehicleContractId;

    @Column(name = "bonus_malus")
    private Double bonusMalus;

    @Column(name = "first_registration_date")
    private Instant firstRegistrationDate;

    @Column(name = "vehicle_value")
    private Double vehicleValue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public Long getVehicleContractId() {
        return vehicleContractId;
    }

    public void setVehicleContractId(Long vehicleContractId) {
        this.vehicleContractId = vehicleContractId;
    }

    public Double getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(Double bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    public Instant getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Instant firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
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