package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Role;
import com.api.inventario.application.dto.inputDto.RoleInputDto;
import com.api.inventario.application.dto.outputDto.RoleOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role roleFromRoleInputDto(RoleInputDto roleInputDto);

    @Mapping(target = "scope", expression = "java(role.getScope().getScope())")
    RoleOutDto roleOutDtoFromRole(Role role);
}
