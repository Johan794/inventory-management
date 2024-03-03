package com.api.inventario.domain.validation.validators;

import com.api.inventario.application.dto.inputDto.UserInputDto;
import com.api.inventario.domain.validation.anotations.EmailOrPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailOrPhoneValidator implements ConstraintValidator<EmailOrPhone, UserInputDto> {

    @Override
    public void initialize(EmailOrPhone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserInputDto userInputDto, ConstraintValidatorContext constraintValidatorContext) {
        if(userInputDto.getEmail() == null || userInputDto.getPhone() == null) {
            return false;
        }
        return !userInputDto.getEmail().isBlank() || !userInputDto.getPhone().isBlank();
    }
}
