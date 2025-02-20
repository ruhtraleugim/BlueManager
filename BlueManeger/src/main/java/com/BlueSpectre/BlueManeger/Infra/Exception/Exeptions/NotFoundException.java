package com.BlueSpectre.BlueManeger.Infra.Exception.Exeptions;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message) {super(message);}

    public NotFoundException() {super("Not Found!");}
}