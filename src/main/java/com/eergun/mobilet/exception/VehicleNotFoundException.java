package com.eergun.mobilet.exception;

import lombok.Getter;

@Getter
public class VehicleNotFoundException extends RuntimeException {
    private ErrorType errorType;

    public VehicleNotFoundException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
