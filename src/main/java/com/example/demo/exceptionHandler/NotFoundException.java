package com.example.demo.exceptionHandler;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

}
