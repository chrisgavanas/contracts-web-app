package com.exception;

public class NotFoundException extends PlatformException {

    public NotFoundException(Enum error) {
        super(error);
    }

}
