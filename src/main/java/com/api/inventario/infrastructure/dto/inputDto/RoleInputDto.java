package com.api.inventario.infrastructure.dto.inputDto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleInputDto {
    private String roleName;
    private String scope;
}
