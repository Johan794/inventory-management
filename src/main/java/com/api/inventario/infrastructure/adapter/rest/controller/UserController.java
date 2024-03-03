package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.port.input.UserService;
import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.application.dto.inputDto.UserInputDto;
import com.api.inventario.application.dto.outputDto.UserOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController implements CrudApi<UserInputDto, UserOutDto> {
    private final UserService userService;
    @Override
    public UserOutDto create(UserInputDto dto) {
        return userService.createUser(dto);
    }

    @Override
    public UserOutDto update(UserInputDto dto) {
        return userService.updateUser(String.valueOf(UUID.randomUUID()));
    }

    @Override
    public UserOutDto delete(String id) {
        return userService.deleteUser(id);
    }

    @Override
    public UserOutDto getById(String id) {
        return userService.getUser(id);
    }

    @Override
    public List<UserOutDto> getAll() {
        return userService.getAllUsers();
    }
}
