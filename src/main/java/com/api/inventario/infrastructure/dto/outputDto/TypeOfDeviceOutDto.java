package com.api.inventario.infrastructure.dto.outputDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfDeviceOutDto {
    private String typeDescription;
}
