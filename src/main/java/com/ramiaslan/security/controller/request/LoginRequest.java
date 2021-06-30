package com.ramiaslan.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "User name must not be null or empty")
    @Size(min = 3, max = 50, message = "User name size must be between {min} and {max} ")
    private String username;

    @NotBlank(message = "Password must not be null or empty")
    @Size(min = 4, max = 32, message = "Password size must be between {min} and {max} ")
    private String password;

}
