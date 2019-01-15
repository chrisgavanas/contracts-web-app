package com.dto.request.contract.mobile;

import com.dto.request.contract.CreateContractDto;

public class CreateMobileContractDto extends CreateContractDto {

    private String imei;

    private String model;

    private String type;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
