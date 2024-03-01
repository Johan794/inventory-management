package com.api.inventario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    private UUID deviceID;

    private String name;

    private String comments;

    private String serialNumber;

    private Integer inventoryNumber;

    @ManyToOne()
    @JoinColumn(name = "device_state_state_id")
    private DeviceState deviceState;

    @ManyToOne()
    @JoinColumn(name = "type_of_device_type_of_device_id")
    private TypeOfDevice typeOfDevice;

    @ManyToOne()
    @JoinColumn(name = "manufacturer_manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne()
    @JoinColumn(name = "user_principal_user_id")
    private UserPrincipal user;






}
