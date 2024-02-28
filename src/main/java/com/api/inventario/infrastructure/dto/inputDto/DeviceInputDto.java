package com.api.inventario.infrastructure.dto.inputDto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeviceInputDto {

    private String name;

    private String comments;

    private String serialNumber;

    private String deviceSate;

    private String typeOfDevice;

    private String  manufacturer;

    private String user;
}
