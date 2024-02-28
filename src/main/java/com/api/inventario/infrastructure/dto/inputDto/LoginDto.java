package com.api.inventario.infrastructure.dto.inputDto;

import lombok.Builder;

@Builder
public record LoginDto(
        String userName,
        String passwors
) {
}
