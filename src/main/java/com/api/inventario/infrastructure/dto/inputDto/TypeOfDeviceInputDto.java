package com.api.inventario.infrastructure.dto.inputDto;


import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeOfDeviceInputDto {
    private String typeName;
    private List<DeviceInputDto> devices;
}
