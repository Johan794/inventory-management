package com.api.inventario.application.service;

import com.api.inventario.application.port.input.UserService;
import com.api.inventario.infrastructure.dto.inputDto.UserInputDto;
import com.api.inventario.infrastructure.dto.outputDto.UserOutDto;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public UserOutDto createUser(UserInputDto userInputDto) {
        return null;
    }

    @Override
    public UserOutDto deleteUser(UserInputDto userInputDto) {
        return null;
    }

    @Override
    public UserOutDto updateUser(UserInputDto userInputDto) {
        return null;
    }

    @Override
    public UserOutDto getUser(String userId) {
        return null;
    }

    @Override
    public List<UserOutDto> getAllUsers() {
        return null;
    }
}
