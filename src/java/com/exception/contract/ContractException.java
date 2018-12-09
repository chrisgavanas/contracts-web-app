package com.exception.contract;

import com.exception.PlatformException;

public class ContractException extends PlatformException {

    public ContractException(Enum error) {
        super(error);
    }

}
