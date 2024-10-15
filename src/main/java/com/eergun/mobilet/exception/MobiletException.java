package com.eergun.mobilet.exception;

import lombok.Getter;
@Getter
public class MobiletException extends RuntimeException {

    private ErrorType errorType;
    
    public MobiletException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}