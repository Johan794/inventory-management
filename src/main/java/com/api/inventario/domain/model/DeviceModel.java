package com.api.inventario.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceModel {

    @Id
    private UUID deviceModelId;

    private String modelName;

    private String modelDescription;

    @OneToMany(mappedBy = "deviceModel")
    List<DeviceModelManufacturer> deviceModelManufacturers;

}
