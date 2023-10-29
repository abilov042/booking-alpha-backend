package com.abilov.bookingalphabackend.core.excepstions.exceptionInfo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseBodyInfo {
    private int status;
    private String error;
    private LocalDateTime date;

}
