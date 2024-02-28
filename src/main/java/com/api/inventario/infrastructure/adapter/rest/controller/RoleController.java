package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.RoleInputDto;
import com.api.inventario.infrastructure.dto.outputDto.RoleOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController implements CrudApi<RoleInputDto, RoleOutDto> {

    @Override
    public RoleOutDto create(RoleInputDto dto) {
        return null;
    }

    @Override
    public RoleOutDto update(RoleInputDto dto) {
        return null;
    }

    @Override
    public RoleOutDto delete(String id) {
        return null;
    }

    @Override
    public RoleOutDto getById(String id) {
        return null;
    }

    @Override
    public List<RoleOutDto> getAll() {
        return null;
    }
}
