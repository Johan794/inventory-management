package com.api.inventario.application.dto.inputDto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceModelInputDto {
    private String modelName;

    private String modelDescription;

    private String manufacturerNames;
}
