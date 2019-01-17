package com.error;

public enum ContractError {

    MISSING_DATA("Missing data"),
    INVALID_DATA("Invalid data"),
    EFFECTIVE_DATE_AFTER_EXPIRATION_DATE("Contract's effective date cannot be after its expiration date"),
    INVALID_CONTRACT_TYPE("Invalid contract type"),
    INVALID_PLATE_NUMBER_FORMAT("Invalid plate number format"),
    BONUS_MALUS_OUT_OF_RANGE("Bonus malus value out of range"),
    CONTRACT_NOT_FOUND("Contract not found"),
    INVALID_YEAR_RANGE("Invalid year range"),
    CANNOT_CALCULATE_COMPENSATION_TRY_AGAIN_LATER("Cannot calculate compensation, try again later"),
    CLIENT_NOT_FOUND("Client not found");

    private String description;

    ContractError(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }

}
