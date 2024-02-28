package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.AuthApi;
import com.api.inventario.infrastructure.dto.auth.JwtDto;
import com.api.inventario.infrastructure.dto.inputDto.LoginDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController implements AuthApi {
    @Override
    public JwtDto login(LoginDto loginDto) {
        return null;
    }
}
