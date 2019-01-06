package com.gateway;

public class CompensationResponseDto {

    private Double compensation;

    private Double premiumAmount;

    public CompensationResponseDto() {
    }

    public CompensationResponseDto(Double compensation, Double premiumAmount) {
        this.compensation = compensation;
        this.premiumAmount = premiumAmount;
    }

    public Double getCompensation() {
        return compensation;
    }

    public void setCompensation(Double compensation) {
        this.compensation = compensation;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}
