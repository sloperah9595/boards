package com.example.kanbas.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    private final Integer code;
    private final String message;

    public NotFoundException(String message) {
        super(message);
        this.code = HttpStatus.NOT_FOUND.value();
        this.message = message;
    }
}
