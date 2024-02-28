package com.api.inventario.infrastructure.dto.outputDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaOutDto {
    private UUID areaId;

    private String areaName;

    private SystemStateOutDto systemSate;

}
