package com.api.inventario.application.dto.outputDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceModeOutDto {
    private UUID deviceModelId;

    private String modelName;

    private String modelDescription;
}
