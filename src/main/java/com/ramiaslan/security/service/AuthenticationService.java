package com.ramiaslan.security.service;

import com.ramiaslan.security.common.security.JwtTokenProvider;
import com.ramiaslan.security.controller.request.LoginRequest;
import com.ramiaslan.security.controller.request.SignUpRequest;
import com.ramiaslan.security.controller.response.LoginResponse;
import com.ramiaslan.security.entity.Role;
import com.ramiaslan.security.entity.User;
import com.ramiaslan.security.exception.CustomException;
import com.ramiaslan.security.repository.RoleRepository;
import com.ramiaslan.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new CustomException("User not found", HttpStatus.BAD_REQUEST));
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtTokenProvider.createToken(username, user.getRole());

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            return loginResponse;
        } catch (AuthenticationException authenticationException) {
            log.info(authenticationException.getMessage());
            throw new CustomException("Username or password not valid",HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        Role role = findRoleByRoleName(signUpRequest.getRoleName());

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setPhone(signUpRequest.getPhone());
        user.setIdentification(signUpRequest.getIdentification());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setBirthDate(signUpRequest.getBirthDate());
        user.setRole(role);
        user.setStatus(true);

        userRepository.save(user);
    }

    private Role findRoleByRoleName(String role) {
        return roleRepository.findByName(role)
                .orElseThrow(() -> new CustomException("role not found", HttpStatus.BAD_REQUEST));
    }

    private String encode(String password) {
        return passwordEncoder.encode(password);
    }

}
