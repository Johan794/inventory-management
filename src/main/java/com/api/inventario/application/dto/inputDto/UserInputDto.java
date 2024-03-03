package com.api.inventario.application.dto.inputDto;

import com.api.inventario.domain.validation.anotations.ColombianNumber;
import com.api.inventario.domain.validation.anotations.EmailOrPhone;
import com.api.inventario.domain.validation.anotations.Password;
import jakarta.annotation.Nullable;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EmailOrPhone
public class UserInputDto {
    private String userType;

    private String idNumber;

    private String name;

    @Nullable
    private String secondName;


    private String firstLastName;

    @Nullable
    private String secondLastName;

    @Email
    private String email;

    @ColombianNumber
    private String phone;

    @NotBlank
    private String userName;


    @Password
    @NotBlank
    private String password;

    @NotBlank
    private String role;

    @NotBlank
    private String areaName;


}
