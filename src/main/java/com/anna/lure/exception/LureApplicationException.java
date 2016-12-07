package com.anna.lure.exception;

public class LureApplicationException extends RuntimeException{
    public LureApplicationException(Errors error) {
        super(error.getCause());
    }
}
