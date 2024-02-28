package com.api.inventario.infrastructure.dto.inputDto;


import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ManufacturerInputDto {
    private String manufacturerName;
    private List<DeviceInputDto> devices;
    private List<String> models;
}
