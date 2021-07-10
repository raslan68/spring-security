package com.ramiaslan.security.common.annotation;

import com.ramiaslan.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniquePhoneValidator implements ConstraintValidator<UniquePhone, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        return !userRepository.existsByPhone(phone);
    }
}
