package com.ramiaslan.security.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class RoleResponse {

    private Integer id;

    private String name;

    private Boolean status;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
