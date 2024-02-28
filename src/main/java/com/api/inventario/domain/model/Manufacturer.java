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
public class Manufacturer {
    @Id
    private UUID manufacturerID;

    private String manufacturerName;

    @OneToMany(mappedBy = "manufacturer")
    private  List<Device> devices;

    @OneToMany(mappedBy = "manufacturer")
    private List<DeviceModelManufacturer> deviceModelManufacturers;



}
