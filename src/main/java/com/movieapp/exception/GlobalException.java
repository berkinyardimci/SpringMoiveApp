package com.movieapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(Exception ex){
        return ResponseEntity.ok("Beklenmeyen bir hata olustu: "+ex.getMessage());
    }
    @ExceptionHandler(MovieAppException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleManagerException(MovieAppException ex){
        ErrorType errorType=ex.getErrorType();
        HttpStatus httpStatus=errorType.httpStatus;
        return new ResponseEntity<>(createError(errorType,ex),httpStatus);
    }

    private ErrorMessage createError(ErrorType errorType, MovieAppException ex) {
        System.out.println("Hata oluştu: "+ex.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }
}
