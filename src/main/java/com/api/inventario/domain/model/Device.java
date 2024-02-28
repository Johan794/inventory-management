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

    private String userName;

    private String comments;

    private String serialNumber;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer inventoryNumber;

    @ManyToOne()
    @JoinColumn(name = "device_state_state_id")
    private State deviceSate;

    @ManyToOne()
    @JoinColumn(name = "kind_of_device_kind_of_device_id")
    private KindOfDevice kindOfDevice;

    @ManyToOne()
    @JoinColumn(name = "manufacturer_manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne()
    @JoinColumn(name = "user_user_id")
    private UserPrincipal user;




}
