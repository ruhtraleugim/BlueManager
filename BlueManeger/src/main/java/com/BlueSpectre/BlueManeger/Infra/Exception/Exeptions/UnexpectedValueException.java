package com.BlueSpectre.BlueManeger.Infra.Exception.Exeptions;

public class UnexpectedValueException extends RuntimeException{
    public UnexpectedValueException(String message) {super(message);}

    public UnexpectedValueException() {super("Not Found!");}
}