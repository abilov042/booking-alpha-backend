package com.abilov.bookingalphabackend.api.globalExceptionHandling;

import com.abilov.bookingalphabackend.core.excepstions.config.NotFountException;
import com.abilov.bookingalphabackend.core.excepstions.exceptionInfo.ResponseHeaderInfo;
import com.abilov.bookingalphabackend.core.result.DataResult;
import com.abilov.bookingalphabackend.core.result.ErrorDataResult;
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
        public ResponseEntity<DataResult<ResponseHeaderInfo>> handlingNotFound(){
            ResponseHeaderInfo responseHeaderInfo = new ResponseHeaderInfo(404, "Bad Request",
                    LocalDateTime.now());
            return new ResponseEntity<>(new ErrorDataResult<>(responseHeaderInfo, "something is bad"),
                    HttpStatus.NOT_FOUND);
        }

}
