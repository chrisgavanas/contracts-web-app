package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "mobile_contract")
public class MobileContract extends Contract {

    @Column(name = "imei")
    private String imei;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_model")
    private MobileDeviceModel model;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private MobileDeviceType type;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public MobileDeviceModel getModel() {
        return model;
    }

    public void setModel(MobileDeviceModel model) {
        this.model = model;
    }

    public MobileDeviceType getType() {
        return type;
    }

    public void setType(MobileDeviceType type) {
        this.type = type;
    }

}

