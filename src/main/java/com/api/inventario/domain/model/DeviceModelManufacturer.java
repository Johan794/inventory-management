package com.api.inventario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeviceModelManufacturer {
    @Id
    private DeviceModelManufacturerPK id;

    @ManyToOne
    @JoinColumn(name = "manufacturer_manufacturer_id")
    private Manufacturer manufacturer;


    @ManyToOne
    @JoinColumn(name =  "device_mode_device_model_id")
    private DeviceModel deviceModel;
}
