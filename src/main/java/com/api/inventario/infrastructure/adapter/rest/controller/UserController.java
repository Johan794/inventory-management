package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.UserInputDto;
import com.api.inventario.infrastructure.dto.outputDto.UserOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements CrudApi<UserInputDto, UserOutDto> {
    @Override
    public UserOutDto create(UserInputDto dto) {
        return null;
    }

    @Override
    public UserOutDto update(UserInputDto dto) {
        return null;
    }

    @Override
    public UserOutDto delete(String id) {
        return null;
    }

    @Override
    public UserOutDto getById(String id) {
        return null;
    }

    @Override
    public List<UserOutDto> getAll() {
        return null;
    }
}
