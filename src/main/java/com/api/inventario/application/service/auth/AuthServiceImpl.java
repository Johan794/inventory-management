package com.api.inventario.application.service.auth;

import com.api.inventario.application.port.input.auth.AuthService;
import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;
import com.api.inventario.infrastructure.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtDto login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginDto.userName(),loginDto.password()));
        return jwtService.generateToken(authentication);
    }
}
