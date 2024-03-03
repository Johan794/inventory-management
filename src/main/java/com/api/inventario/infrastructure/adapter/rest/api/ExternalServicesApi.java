package com.api.inventario.infrastructure.adapter.rest.api;

import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ExternalServicesApi {
    @PostMapping("/login")
    JwtDto loginExternalService( @RequestBody LoginDto loginDto);

    @GetMapping()
    JsonObject getFromApi(
            @RequestParam String routes,
            @RequestParam String token,
            @RequestParam String params);

    @PostMapping()
    JsonObject postFromApi(@RequestParam String routes,
                           @RequestParam String token,
                           @RequestParam String params);
}
