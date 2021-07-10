package com.ramiaslan.security.common.annotation;


import com.ramiaslan.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueIdentificationValidator implements ConstraintValidator<UniqueIdentification, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String identification, ConstraintValidatorContext context) {
        return !userRepository.existsByIdentification(identification);
    }
}
