package com.eergun.mobilet.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum ErrorType {

    INTERNAL_SERVER_ERROR(500,"Sunucuda beklenmeyen bir hata oluştu, lütfen tekrar deneyin.", HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_ERROR(4000,"Parametreler hatalıdır, lütfene tekrar deneyiniz",HttpStatus.BAD_REQUEST),
    BAKIYE_YETERSIZ(4001,"Bakiyeniz yetersiz!",HttpStatus.BAD_REQUEST),
    CARD_NOT_FOUND(4002,"Kart bulunamadı.",HttpStatus.NOT_FOUND),
    VEHICLE_NOT_FOUND(4003,"Araç bulunamadı",HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    private HttpStatus status;
    ErrorType(int code,String message,HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }


}
