package com.ramiaslan.security.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 3951144193502213063L;

    private final String message;

    @Getter
    private final HttpStatus httpStatus;

    @Override
    public String getMessage() {
        return message;
    }

}
