package com.eergun.mobilet.exception;

import com.eergun.mobilet.utility.Audio.AudioPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> runtimeExcepitonHandler(){
        return  createResponseEntity(ErrorType.INTERNAL_SERVER_ERROR,null);
    }

    public ResponseEntity<ErrorMessage> createResponseEntity(ErrorType errorType, List<String> fields){
        log.error("HATALAR HATALAR......." + errorType.getMessage() + fields);
        return new ResponseEntity<>(ErrorMessage.builder()
                .code(errorType.getCode())
                .fields(fields)
                .message(errorType.getMessage())
                .success(false).build(),errorType.getStatus());
    }

    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        List<String> fieldErrors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(f->{
                    //  f.getField() -> hata fırlatan nesnenin değişken adı örn: email
                    //  f.getDefaultMessage() -> hataya ait detay bilgisi örn: geçerli bir email giriniz.
                    fieldErrors.add("Değişken adı..: "+ f.getField()+ " - Hata Detayı...: "+ f.getDefaultMessage());
                });
        return createResponseEntity(ErrorType.VALIDATION_ERROR,fieldErrors);
    }
    
    @ExceptionHandler(MobiletException.class)
    public ResponseEntity<ErrorMessage> mobiletExceptionHandler(MobiletException exception){
        if (exception.getErrorType().equals(ErrorType.BAKIYE_YETERSIZ)) {
            AudioPlayer.playAudio("src/main/java/com/eergun/mobilet/utility/Audio/BakiyenizYetersiz.wav");
        }
        return  createResponseEntity(exception.getErrorType(),null);
    }
}