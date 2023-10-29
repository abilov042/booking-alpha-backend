package com.abilov.bookingalphabackend.core.excepstions.config;

public class ExistsEmailException extends RuntimeException{
    public ExistsEmailException(String message){
        super(message);
    }
}
