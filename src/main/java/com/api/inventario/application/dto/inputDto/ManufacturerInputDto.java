package com.api.inventario.application.dto.inputDto;


import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManufacturerInputDto {
    private String manufacturerName;
    private List<DeviceInputDto> devices;
    private List<String> models;
}
