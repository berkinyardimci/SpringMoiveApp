package com.movieapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(5100,"Sunucu Hatası",HttpStatus.INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND(4001,"Böyle Bir kullanıcı Bulunamamıştır",HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
