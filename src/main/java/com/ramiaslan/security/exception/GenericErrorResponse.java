package com.ramiaslan.security.exception;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class GenericErrorResponse {

    private Integer code;
    private String message;
    private String dateTime;

    public GenericErrorResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}