package com.ramiaslan.security.controller;

import com.ramiaslan.security.controller.request.RoleCreateRequest;
import com.ramiaslan.security.controller.request.RoleUpdateRequest;
import com.ramiaslan.security.controller.response.GenericResponse;
import com.ramiaslan.security.controller.response.RoleResponse;
import com.ramiaslan.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody RoleUpdateRequest roleUpdateRequest){
        roleService.update(roleUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "role successfully updated"));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        roleService.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "role is deleted"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable("id") Integer id){
        RoleResponse roleResponse = roleService.getRoleById(id);
        return ResponseEntity.ok(roleResponse);
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRole(){
       List<RoleResponse> roleResponse =  roleService.getAllRole();
       return ResponseEntity.ok(roleResponse);
    }

}
