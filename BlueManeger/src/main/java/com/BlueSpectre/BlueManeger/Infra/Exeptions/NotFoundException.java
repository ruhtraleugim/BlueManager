package com.BlueSpectre.BlueManeger.Infra.Exeptions;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message) {super(message);}

    public NotFoundException() {super("Not Found!");}
}