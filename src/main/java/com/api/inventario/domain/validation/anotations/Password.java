package com.api.inventario.domain.validation.anotations;

import com.api.inventario.domain.validation.validators.PasswordValidator;
import jakarta.validation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PasswordValidator.class})
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "the password must have more than 8 characters";
    String field() default "password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
