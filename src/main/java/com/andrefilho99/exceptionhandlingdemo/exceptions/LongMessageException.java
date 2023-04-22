package com.andrefilho99.exceptionhandlingdemo.exceptions;

public class LongMessageException extends RuntimeException {

    public LongMessageException(String message) {
        super(message);
    }
}
