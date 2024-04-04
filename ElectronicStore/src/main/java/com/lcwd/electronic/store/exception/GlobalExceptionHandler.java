package com.lcwd.electronic.store.exception;

import com.lcwd.electronic.store.dtos.ApiResponseMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger log= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    //handle resource not found exception
    public ResponseEntity<ApiResponseMessage> resourceNotFoundExcepionHandler( ResourceNotFoundException ex)
    {
        log.info("Exception handler invoked!!");
        ApiResponseMessage response=ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
