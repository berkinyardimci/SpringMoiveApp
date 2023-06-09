package com.movieapp.exception;

import lombok.Getter;

@Getter
public class MovieAppException extends RuntimeException{

    private final ErrorType errorType;

    public MovieAppException(ErrorType errorType){
        this.errorType = errorType;
    }
}
