package com.ramiaslan.security.controller.response;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Getter
public class GenericResponse {

    private Integer code;
    private String message;
    private String dateTime;

    public GenericResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
