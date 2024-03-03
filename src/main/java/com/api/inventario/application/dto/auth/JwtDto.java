package com.api.inventario.application.dto.auth;

import lombok.Builder;
import lombok.Getter;

@Builder
public record JwtDto(String token , String role) {
}
