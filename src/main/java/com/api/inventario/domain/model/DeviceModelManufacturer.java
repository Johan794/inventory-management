package com.api.inventario.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeviceModelManufacturer {
    @EmbeddedId
    private DeviceModelManufacturerPK id;

}
