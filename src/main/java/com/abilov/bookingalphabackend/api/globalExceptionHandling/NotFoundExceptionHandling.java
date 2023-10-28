package com.abilov.bookingalphabackend.api.globalExceptionHandling;

import com.abilov.bookingalphabackend.core.excepstions.config.NotFountException;
import com.abilov.bookingalphabackend.core.excepstions.exceptionInfos.NotFoundExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class NotFoundExceptionHandling {

        @ExceptionHandler(value = NotFountException.class)
        public ResponseEntity<NotFoundExceptionInfo> handlingNotFound(){
            NotFoundExceptionInfo notFoundExceptionInfo = new NotFoundExceptionInfo(404, "not found", LocalDateTime.now());
            return new ResponseEntity<>(notFoundExceptionInfo, HttpStatus.BAD_REQUEST);
        }

}
