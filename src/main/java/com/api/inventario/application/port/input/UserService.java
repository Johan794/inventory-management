package com.api.inventario.application.port.input;

import com.api.inventario.application.dto.inputDto.UserInputDto;
import com.api.inventario.application.dto.outputDto.UserOutDto;

import java.util.List;

public interface UserService {
    UserOutDto createUser(UserInputDto userInputDto);

    UserOutDto deleteUser(String userId);

    UserOutDto updateUser (String userId);

    UserOutDto getUser(String userId);

    List<UserOutDto> getAllUsers();
}
