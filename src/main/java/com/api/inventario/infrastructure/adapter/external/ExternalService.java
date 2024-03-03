package com.api.inventario.infrastructure.adapter.external;

import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;
import com.google.gson.JsonObject;
import jakarta.annotation.Nullable;

public interface ExternalService {
    JwtDto loginExternalService(LoginDto loginDto);

    JsonObject getFromApi(String route, String token, @Nullable String params);

    JsonObject postFromApi(String route, String token, @Nullable String params);




}
