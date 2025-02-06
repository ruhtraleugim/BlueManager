package com.BlueSpectre.BlueManeger.Infra.Exeptions.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.BlueSpectre.BlueManeger.Infra.Exeptions.UnexpectedValueException;
import com.BlueSpectre.BlueManeger.Infra.Exeptions.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
        
    @ExceptionHandler()
    private ResponseEntity<String> NotFoundHendler(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Founded");
    }

    @ExceptionHandler()
    private ResponseEntity<String> UnexpectedValueException(UnexpectedValueException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected Value, please confirm the information");
    }
}