package com.api.inventario.domain.validation.validators;

import com.api.inventario.domain.validation.anotations.ColombianNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ColombianNumberValidator implements ConstraintValidator<ColombianNumber, String> {
    @Override
    public void initialize(ColombianNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("\\+573[0-9]{9}");
    }
}
