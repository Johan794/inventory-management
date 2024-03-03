package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;
import com.api.inventario.infrastructure.adapter.external.ExternalService;
import com.api.inventario.infrastructure.adapter.rest.api.ExternalServicesApi;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external")
public class ExternalServicesController implements ExternalServicesApi {
    private final ExternalService externalService;
    @Override
    public JwtDto loginExternalService(LoginDto loginDto) {
        return externalService.loginExternalService(loginDto);
    }

    @Override
    public JsonObject getFromApi(String routes,String token,String params) {
        return externalService.getFromApi(routes, token, params);
    }

    @Override
    public JsonObject postFromApi(String routes,String token,String params) {
        return externalService.postFromApi(routes, token, params);
    }
}
