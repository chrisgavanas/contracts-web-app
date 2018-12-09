package com.exception;

public class PlatformException extends RuntimeException {

    public PlatformException(Enum error) {
        super(error.name());
    }

}
