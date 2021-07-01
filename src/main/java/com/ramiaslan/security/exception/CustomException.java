package com.ramiaslan.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends  RuntimeException{

    private static final long serialVersionUID = 3951144193502213063L;

    public CustomException(String message) {
        super(message);
    }

}
