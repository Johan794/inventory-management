package com.api.inventario.domain.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DeviceModelManufacturerPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "manufacturer_manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "device_model_device_model_id")
    private DeviceModel deviceModel;
}
