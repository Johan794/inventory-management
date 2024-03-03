package com.api.inventario.infrastructure.adapter.external.impl;

import com.api.inventario.application.dto.auth.JwtDto;
import com.api.inventario.application.dto.inputDto.LoginDto;
import com.api.inventario.infrastructure.adapter.external.ExternalService;
import com.google.gson.JsonObject;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Setter
public class ExternalServiceImpl implements ExternalService {
    private final WebClient webClient;

    @Value("${api.base.login.url}")
    private String loginRoute;
    @Override
    public JwtDto loginExternalService(LoginDto loginDto) {
        return webClient.post()
                .uri(loginRoute)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(loginDto, LoginDto.class)
                .retrieve()
                .bodyToMono(JwtDto.class)
                .block();
    }

    @Override
    public JsonObject getFromApi(String route, String token, @Nullable String params) {
        WebClient.RequestHeadersUriSpec<?> request = (WebClient.RequestHeadersUriSpec<?>) webClient.get()
                .uri(route)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token));

        if (params != null && !params.isEmpty()) {
            request = (WebClient.RequestHeadersUriSpec<?>) request.uri(route, params);
        }

        return request.retrieve()
                .bodyToMono(JsonObject.class)
                .block();

    }

    @Override
    public JsonObject postFromApi(String route, String token, @Nullable String params) {
        WebClient.RequestHeadersUriSpec<?> request = (WebClient.RequestHeadersUriSpec<?>) webClient.post()
                .uri(route)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .headers(h -> h.setBearerAuth(token));

        if (params != null && !params.isEmpty()) {
            request = (WebClient.RequestHeadersUriSpec<?>) request.uri(route, params);
        }

        return request.retrieve()
                .bodyToMono(JsonObject.class)
                .block();
    }
}
