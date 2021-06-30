package com.ramiaslan.security.controller;

import com.ramiaslan.security.controller.request.LoginRequest;
import com.ramiaslan.security.controller.request.SignUpRequest;
import com.ramiaslan.security.controller.response.GenericResponse;
import com.ramiaslan.security.controller.response.LoginResponse;
import com.ramiaslan.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(name = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);
        return ResponseEntity.ok(new GenericResponse(200, "sign up successfully."));
    }

}
