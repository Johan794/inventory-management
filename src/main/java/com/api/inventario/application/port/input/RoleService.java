package com.api.inventario.application.port.input;

import com.api.inventario.infrastructure.dto.inputDto.RoleInputDto;
import com.api.inventario.infrastructure.dto.outputDto.RoleOutDto;

import java.util.List;

public interface RoleService {
    RoleOutDto createRole(RoleInputDto roleInputDto);

    RoleOutDto updateRole(RoleInputDto roleInputDto);

    RoleOutDto deleteRole(String roleId);

    RoleOutDto getRole(String roleId);

    List<RoleOutDto>getAllRoles();


}
