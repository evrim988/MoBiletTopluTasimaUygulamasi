package com.eergun.mobilet.exception;

import lombok.Getter;

@Getter
public class BakiyeYetersizException extends RuntimeException{
    private ErrorType errorType;

    public BakiyeYetersizException(ErrorType errorType) {
       super(errorType.getMessage());
       this.errorType = errorType;
    }

}