package com.jet.movieHexa.infrastructure.exception;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String message){
        super(message);
    }
}
