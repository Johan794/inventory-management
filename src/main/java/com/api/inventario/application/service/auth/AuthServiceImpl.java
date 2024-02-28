package com.api.inventario.application.service.auth;

import com.api.inventario.application.port.input.auth.AuthService;
import com.api.inventario.infrastructure.dto.auth.JwtDto;
import com.api.inventario.infrastructure.dto.inputDto.LoginDto;

public class AuthServiceImpl implements AuthService {
    @Override
    public JwtDto login(LoginDto loginDto) {
        return null;
    }
}
