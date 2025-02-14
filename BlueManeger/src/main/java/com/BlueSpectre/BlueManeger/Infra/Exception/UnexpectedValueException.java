package com.BlueSpectre.BlueManeger.Infra.Exception;

public class UnexpectedValueException extends RuntimeException{
    public UnexpectedValueException(String message) {super(message);}

    public UnexpectedValueException() {super("Not Found!");}
}