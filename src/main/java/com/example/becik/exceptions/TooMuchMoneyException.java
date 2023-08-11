package com.example.becik.exceptions;

public class TooMuchMoneyException extends RuntimeException{
    public TooMuchMoneyException(String message){
            super(message);
        }
}
