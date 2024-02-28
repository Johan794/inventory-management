package com.api.inventario.infrastructure.adapter.rest.api;

import com.api.inventario.infrastructure.dto.auth.JwtDto;
import com.api.inventario.infrastructure.dto.inputDto.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;

public interface AuthApi {
    @PostMapping("/login")
    JwtDto login(LoginDto loginDto);
}
