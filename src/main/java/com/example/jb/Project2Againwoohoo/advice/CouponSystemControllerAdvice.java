package com.example.jb.Project2Againwoohoo.advice;

import com.example.jb.Project2Againwoohoo.exceptions.CouponSecurityExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.CustomExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CouponSystemControllerAdvice {


    @ExceptionHandler(value = {CustomExceptions.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails errorHelper(Exception e) {
        return new ErrorDetails("An error occurred", e.getMessage());
    }


    @ExceptionHandler(value = CouponSecurityExceptions.class)
    public ResponseEntity<?> handleSecException(CouponSecurityExceptions e) {
        ErrorDetails errorDetails = new ErrorDetails("An error occurred", e.getMessage());
        return new ResponseEntity<>(errorDetails, e.getSecurityErrMsg().getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
