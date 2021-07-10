package com.ramiaslan.security.service;

import com.ramiaslan.security.controller.request.RoleCreateRequest;
import com.ramiaslan.security.controller.request.RoleUpdateRequest;
import com.ramiaslan.security.controller.response.RoleResponse;
import com.ramiaslan.security.entity.Role;
import com.ramiaslan.security.exception.CustomException;
import com.ramiaslan.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void update(RoleUpdateRequest roleUpdateRequest) {
        Role role = getById(roleUpdateRequest.getId());
        existByName(role.getName());

        role.setStatus(roleUpdateRequest.getStatus());
        role.setName(roleUpdateRequest.getName());
        roleRepository.save(role);
    }

    public void delete(Integer id) {
        Role role = getById(id);
        roleRepository.delete(role);
    }

    public RoleResponse getRoleById(Integer id) {
        Role role = getById(id);
        return convert(role);
    }

    public List<RoleResponse> getAllRole() {
        return roleRepository.findAll()
                .stream().map(this::convert)
                .collect(Collectors.toList());
    }

    private void existByName(String name) {
        if (roleRepository.existsByName(name)) {
            throw new CustomException("role name must be unique");
        }
    }

    private Role getById(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            throw new CustomException("role is not found ");
        }
        return role.get();
    }

    private RoleResponse convert(Role role) {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        roleResponse.setStatus(role.getStatus());
        roleResponse.setCreatedDate(role.getCreatedDate());
        roleResponse.setUpdatedDate(role.getUpdatedDate());
        return roleResponse;
    }

}
