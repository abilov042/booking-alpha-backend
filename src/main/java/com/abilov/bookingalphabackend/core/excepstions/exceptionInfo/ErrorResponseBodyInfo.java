package com.abilov.bookingalphabackend.core.excepstions.exceptionInfo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseHeaderInfo {
    private int status;
    private String description;
    private LocalDateTime date;

}
