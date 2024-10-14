package com.eergun.mobilet.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    public ResponseEntity<ErrorMessage> createResponseEntity(ErrorType errorType, List<String> fields){
        log.error("HATALAR HATALAR.......");
        return new ResponseEntity<>(ErrorMessage.builder()
                .code(errorType.getCode())
                .fields(fields)
                .message(errorType.getMessage())
                .success(false).build(),errorType.getStatus());
    }

    @ExceptionHandler(BakiyeYetersizException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> bakiyeYetersizExceptionHandler(ErrorType errorType){
        return createResponseEntity(errorType,null);
    }

    //TODO: DEVAMI GELECEK!!


}
