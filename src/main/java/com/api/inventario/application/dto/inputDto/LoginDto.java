package com.api.inventario.application.dto.inputDto;

import lombok.Builder;
import lombok.Getter;

@Builder
public record LoginDto(
        String userName,
        String password
) {
}
