package com.anna.lure.controller;

import com.anna.lure.exception.LureApplicationException;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
@CrossOrigin(origins = "http://localhost:8080")
public class GlobalExceptionController {

    @ExceptionHandler(LureApplicationException.class)
    public ResponseEntity<ObjectNode> handleCustomException(Exception ex) {
        ObjectNode error = JsonNodeFactory.instance.objectNode();
        error.put("message", ex.getMessage());
        error.put("cause", "CustomException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ObjectNode> handleIOException(Exception ex) {
        ObjectNode error = JsonNodeFactory.instance.objectNode();
        error.put("message", ex.getMessage());
        error.put("cause", "IOException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ObjectNode> handleIllegalArgumentException(Exception ex) {
        ObjectNode error = JsonNodeFactory.instance.objectNode();
        error.put("message", ex.getMessage());
        error.put("cause", "IllegalArgumentException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
