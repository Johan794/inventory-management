package com.api.inventario.application.port.input.auth;

import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;

public interface AuthService {
    JwtDto login(LoginDto loginDto);
}
