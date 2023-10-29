package com.abilov.bookingalphabackend.core.result;

import lombok.Getter;

@Getter
public class Result {
    private boolean isSuccess;
    private String message;

    public Result(){}
    public Result(boolean isSuccess){
        this.isSuccess = isSuccess;
    }

    public Result(boolean isSuccess, String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }




}
