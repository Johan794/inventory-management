package com.api.inventario.application.port.input;

import com.api.inventario.infrastructure.dto.inputDto.UserInputDto;
import com.api.inventario.infrastructure.dto.outputDto.UserOutDto;

import java.util.List;

public interface UserService {
    UserOutDto createUser(UserInputDto userInputDto);

    UserOutDto deleteUser(UserInputDto userInputDto);

    UserOutDto updateUser (UserInputDto userInputDto);

    UserOutDto getUser(String userId);

    List<UserOutDto> getAllUsers();
}
