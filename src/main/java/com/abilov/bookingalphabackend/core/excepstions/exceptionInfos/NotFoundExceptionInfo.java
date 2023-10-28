package com.abilov.bookingalphabackend.core.excepstions.exceptionInfos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NotFoundExceptionInfo {
    private int status;
    private String description;
    private LocalDateTime date;

}
