package com.exception.vehicle;

import com.exception.PlatformException;

public class VehicleException extends PlatformException {

    public VehicleException(Enum error) {
        super(error);
    }

}
