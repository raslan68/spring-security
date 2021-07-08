package com.ramiaslan.security.controller;

import com.ramiaslan.security.controller.request.RoleCreateRequest;
import com.ramiaslan.security.controller.response.GenericResponse;
import com.ramiaslan.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody RoleCreateRequest roleCreateRequest) {
        roleService.create(roleCreateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "role successfully created."));
    }

}
