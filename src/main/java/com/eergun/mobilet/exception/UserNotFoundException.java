package com.eergun.mobilet.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{
    private ErrorType errorType;

    public UserNotFoundException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}