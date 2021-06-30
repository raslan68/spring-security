package com.ramiaslan.security.service;

import com.ramiaslan.security.controller.request.LoginRequest;
import com.ramiaslan.security.controller.request.SignUpRequest;
import com.ramiaslan.security.controller.response.LoginResponse;
import com.ramiaslan.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    public void signUp(SignUpRequest signUpRequest) {

    }

}
