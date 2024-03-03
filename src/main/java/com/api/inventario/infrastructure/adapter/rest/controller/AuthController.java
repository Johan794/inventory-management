package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.port.input.auth.AuthService;
import com.api.inventario.infrastructure.adapter.rest.api.AuthApi;
import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {
    private final AuthService authService;
    @Override
    public JwtDto login(LoginDto loginDto) {
        return authService.login(loginDto);
    }
}
