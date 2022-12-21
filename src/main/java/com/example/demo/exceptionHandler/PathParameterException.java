package com.example.demo.exceptionHandler;

public class PathParameterException extends RuntimeException{

    public PathParameterException(String message) {
        super(message);
    }

}
