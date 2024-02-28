package com.api.inventario.infrastructure.dto.inputDto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeviceModelInputDto {
    private String modelName;

    private String modelDescription;
}