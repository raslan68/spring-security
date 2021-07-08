package com.ramiaslan.security.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapperImpl;

@Slf4j
public final class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String errorMessage;
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        errorMessage = constraintAnnotation.message();
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        log.info("Field match initialize.");
        final BeanWrapperImpl bean = new BeanWrapperImpl(value);
        final Object firstObj = bean.getPropertyValue(firstFieldName);
        final Object secondObj = bean.getPropertyValue(secondFieldName);

        boolean returnValue = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        try {
            if (!returnValue) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(secondFieldName)
                        .addConstraintViolation();
            }
            return returnValue;
        } catch (final Exception ignore) {
            log.error(ignore.getMessage());
        }

        return true;
    }

}