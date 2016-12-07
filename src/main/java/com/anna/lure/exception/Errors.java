package com.anna.lure.exception;

import lombok.Getter;

@Getter
public enum Errors {
    LURE_NOT_FOUND("Unfortunately, requested lure was not found");

    private String cause;

    Errors(final String cause) {
        this.cause = cause;
    }
}
