package com.example.kanbas.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerException extends RuntimeException {

    private final Integer code;
    private final String message;

    public InternalServerException(String message) {
        super(message);
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
    }
}
