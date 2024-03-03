package com.api.inventario.application.dto.outputDto;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOutDto {

    private String userType;

    private String idNumber;

    private String name;

    @Nullable
    private String secondName;


    private String firstLastName;

    @Nullable
    private String secondLastName;


    private String email;

    private String phone;

    private String userName;

    private String password;

    private RoleOutDto role;

    private AreaOutDto area;

    private List<DeviceOutDto> devices;

    private SystemStateOutDto systemSate;


}
