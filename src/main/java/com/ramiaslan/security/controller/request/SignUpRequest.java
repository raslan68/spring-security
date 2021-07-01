package com.ramiaslan.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Getter
@Setter
public class SignUpRequest {

    @NotBlank(message = "User name must not be null or empty")
    @Size(min = 3, max = 50, message = "User name size must be between {min} and {max} ")
    private String username;

    @NotBlank(message = "Password must not be null or empty")
    @Size(min = 4, max = 32, message = "Password size must be between {min} and {max} ")
    private String password;

    @NotBlank(message = "Confirm password must not be null or empty")
    @Size(min = 4, max = 32, message = "Confirm password size must be between {min} and {max} ")
    private String confirmPassword;

    @NotBlank(message = "Email must not be null or empty")
    @Size(min = 4, max = 100, message = "Email size must be between {min} and {max} ")
    private String email;

    @NotBlank(message = "Phone must not be null or empty")
    @Size(min = 4, max = 25, message = "Phone size must be between {min} and {max} ")
    private String phone;

    @NotBlank(message = "Identification must not be null or empty")
    @Size(min = 4, max = 25, message = "Identification size must be between {min} and {max} ")
    private String identification;

    @NotBlank(message = "First name must not be null or empty")
    @Size(min = 4, max = 50, message = "First name size must be between {min} and {max} ")
    private String firstName;

    @NotBlank(message = "Last name must not be null or empty")
    @Size(min = 4, max = 50, message = "Last name size must be between {min} and {max} ")
    private String lastName;

    private LocalDate birthDate;

    private String roleName;

}
