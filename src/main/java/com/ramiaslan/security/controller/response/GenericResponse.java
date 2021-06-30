package com.ramiaslan.security.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class GenericResponse {

    private Integer code;
    private String message;

}
