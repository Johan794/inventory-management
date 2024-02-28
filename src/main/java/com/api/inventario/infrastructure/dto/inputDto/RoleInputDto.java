package com.api.inventario.infrastructure.dto.inputDto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RoleInputDto {
    private String roleName;

    private List<String> authorities;
}
