package com.abilov.bookingalphabackend.core.result;

import lombok.Getter;

@Getter
public class DataResult<T> extends Result{
    T data;

    public DataResult(boolean isSuccess, T data){
        super(isSuccess);
        this.data = data;
    }

    public DataResult(boolean isSuccess, T data, String message){
        super(isSuccess, message);
        this.data = data;
    }

}
