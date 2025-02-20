package com.BlueSpectre.BlueManeger.Infra.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ExceptionResponse {

    private HttpStatus status;
    private String message;

    public ExceptionResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}