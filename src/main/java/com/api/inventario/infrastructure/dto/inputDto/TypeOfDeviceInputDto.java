package com.api.inventario.infrastructure.dto.inputDto;


import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TypeOfDeviceInputDto {
    private String typeDescription;
    private List<DeviceInputDto> devices;
}
