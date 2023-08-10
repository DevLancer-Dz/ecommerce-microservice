package com.damine.productservice.handler;

import com.damine.productservice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?>   handelResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<>(resourceNotFoundException.getMessage(),HttpStatus.NOT_FOUND) ;
    }
}
