package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Role;
import com.api.inventario.infrastructure.dto.inputDto.RoleInputDto;
import com.api.inventario.infrastructure.dto.outputDto.RoleOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role roleFromRoleInputDto(RoleInputDto roleInputDto);

    RoleOutDto roleOutDtoFromRole(Role role);
}
