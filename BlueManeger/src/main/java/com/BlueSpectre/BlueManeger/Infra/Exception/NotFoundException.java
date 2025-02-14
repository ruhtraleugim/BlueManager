package com.BlueSpectre.BlueManeger.Infra.Exception;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message) {super(message);}

    public NotFoundException() {super("Not Found!");}
}