package com.ramiaslan.security.service;

import com.ramiaslan.security.controller.request.RoleCreateRequest;
import com.ramiaslan.security.entity.Role;
import com.ramiaslan.security.exception.CustomException;
import com.ramiaslan.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void create(RoleCreateRequest roleCreateRequest) {
        existByName(roleCreateRequest.getName());

        Role role = new Role();
        role.setStatus(roleCreateRequest.getStatus());
        role.setName(roleCreateRequest.getName());

        roleRepository.save(role);
    }

    private void existByName(String name) {
        if (roleRepository.existsByName(name)) {
            throw new CustomException("role name must be unique");
        }
    }

}
