package com.api.inventario.application.dto.outputDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceOutDto {
    private String name;

    private String comments;

    private String serialNumber;

    private Integer inventoryNumber;

    private String typeOfDevice;

    private String deviceState;

    private String manufacturer;

    private String user;
}
