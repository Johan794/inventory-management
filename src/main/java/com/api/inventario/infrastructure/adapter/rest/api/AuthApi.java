package com.api.inventario.infrastructure.adapter.rest.api;

import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthApi {
    @PostMapping("/login")
    JwtDto login(@RequestBody LoginDto loginDto);
}
