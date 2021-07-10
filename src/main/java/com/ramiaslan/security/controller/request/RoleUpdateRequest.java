package com.ramiaslan.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RoleUpdateRequest {

    @Positive(message = "id must be positive")
    @NotNull(message = "id must not be null")
    private Integer id;

    @NotNull(message = "Status must not be null")
    private Boolean status;

    @NotBlank(message = "Role name must not be null or empty")
    @Size(min = 3, max = 50, message = "Role name size must be between {min} and {max} ")
    private String name;

}
