package com.api.inventario.infrastructure.dto.auth;

import lombok.Builder;

@Builder
public record JwtDto(String token , String role) {
}
