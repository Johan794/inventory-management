package com.api.inventario.application.dto.inputDto;

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
