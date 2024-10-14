package com.eergun.mobilet.exception;

import lombok.Getter;

@Getter
public class CardNotFoundException extends RuntimeException {
    private ErrorType errorType;

    public CardNotFoundException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}