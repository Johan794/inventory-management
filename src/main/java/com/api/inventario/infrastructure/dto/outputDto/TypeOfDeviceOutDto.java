package com.api.inventario.infrastructure.dto.outputDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfDeviceOutDto {
    private String typeName;
    private List<DeviceOutDto> devices;
}
