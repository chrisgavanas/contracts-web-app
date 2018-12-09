package com.error;

public enum ClientError {

    CLIENT_NOT_FOUND("Client not found");
    
    private String description;

    ClientError(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
    
}
