package com.BlueSpectre.BlueManeger.Infra.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
        
    @ExceptionHandler()
    private ResponseEntity<ExceptionResponse> NotFoundHendler(NotFoundException e){
        ExceptionResponse exeptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exeptionResponse);
    }

    @ExceptionHandler()
    private ResponseEntity<ExceptionResponse> UnexpectedValueException(UnexpectedValueException e){
        ExceptionResponse exeptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exeptionResponse);
    }
}