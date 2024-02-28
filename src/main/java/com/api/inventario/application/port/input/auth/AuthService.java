package com.api.inventario.application.port.input.auth;

import com.api.inventario.infrastructure.dto.auth.JwtDto;
import com.api.inventario.infrastructure.dto.inputDto.LoginDto;

public interface AuthService {
    JwtDto login(LoginDto loginDto);
}
