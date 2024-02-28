package com.api.inventario.infrastructure.dto.inputDto;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AreaInputDto {
    @NotBlank
    private String areaName;
}
