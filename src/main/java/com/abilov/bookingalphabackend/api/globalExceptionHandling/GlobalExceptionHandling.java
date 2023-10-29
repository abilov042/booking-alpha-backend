package com.abilov.bookingalphabackend.api.globalExceptionHandling;

import com.abilov.bookingalphabackend.core.excepstions.config.ConfirmPasswordException;
import com.abilov.bookingalphabackend.core.excepstions.config.ExistsEmailException;
import com.abilov.bookingalphabackend.core.excepstions.config.NotFountException;
import com.abilov.bookingalphabackend.core.excepstions.exceptionInfo.ErrorResponseBodyInfo;
import com.abilov.bookingalphabackend.core.result.DataResult;
import com.abilov.bookingalphabackend.core.result.ErrorDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class GlobalExceptionHandling {

        @ExceptionHandler(value = NotFountException.class)
        public ResponseEntity<DataResult<ErrorResponseBodyInfo>> handlingNotFound(){
            ErrorResponseBodyInfo responseHeaderInfo = new ErrorResponseBodyInfo(404, "Bad Request",
                    LocalDateTime.now());
            return new ResponseEntity<>(new ErrorDataResult<>(responseHeaderInfo, "something is bad"),
                    HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseEntity<DataResult<?>> handlingMethodArgumentValid(MethodArgumentNotValidException exceptions){
            Map<String, String> validationErrors = new HashMap<>();
            for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return new ResponseEntity<>(new ErrorDataResult<>(validationErrors, "user can't saved"), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value = ConfirmPasswordException.class)
        public ResponseEntity<DataResult<ErrorResponseBodyInfo>> confirmPasswordValid(){
            ErrorResponseBodyInfo responseHeaderInfo = new ErrorResponseBodyInfo(400, "Bad Request",
                    LocalDateTime.now());
            return new ResponseEntity<>(new ErrorDataResult<>(responseHeaderInfo, "password not same"), HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(value = ExistsEmailException.class)
    public ResponseEntity<DataResult<ErrorResponseBodyInfo>> existsEmailValid(){
        ErrorResponseBodyInfo responseHeaderInfo = new ErrorResponseBodyInfo(400, "Bad Request",
                LocalDateTime.now());
        return new ResponseEntity<>(new ErrorDataResult<>(responseHeaderInfo, "email already use"), HttpStatus.BAD_REQUEST);
    }

}
