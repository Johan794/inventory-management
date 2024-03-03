package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.port.input.RoleService;
import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.application.dto.inputDto.RoleInputDto;
import com.api.inventario.application.dto.outputDto.RoleOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController implements CrudApi<RoleInputDto, RoleOutDto> {
    private final RoleService roleService;

    @Override
    public RoleOutDto create(RoleInputDto dto) {
        return roleService.createRole(dto);
    }

    @Override
    public RoleOutDto update(RoleInputDto dto) {
        return roleService.updateRole(dto);
    }

    @Override
    public RoleOutDto delete(String id) {
        return roleService.deleteRole(id);
    }

    @Override
    public RoleOutDto getById(String id) {
        return roleService.getRole(id);
    }

    @Override
    public List<RoleOutDto> getAll() {
        return roleService.getAllRoles();
    }
}
