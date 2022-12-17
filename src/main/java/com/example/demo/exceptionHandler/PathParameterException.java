package com.example.demo.exceptionHandler;

public class PathParameterException extends RuntimeException{

    public PathParameterException() {
        super();
    }

    public PathParameterException(String message) {
        super(message);
    }

    public PathParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
