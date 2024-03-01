package com.api.inventario.infrastructure.dto.inputDto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceInputDto {

    private String name;

    private String comments;

    private String serialNumber;

    private Integer inventoryNumber;

    private String deviceState;

    private String typeOfDevice;

    private String  manufacturer;

    private String user;
}
