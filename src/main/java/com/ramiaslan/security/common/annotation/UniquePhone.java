package com.ramiaslan.security.common.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniquePhoneValidator.class)
public @interface UniquePhone {

    String message() default "phone numbers must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
