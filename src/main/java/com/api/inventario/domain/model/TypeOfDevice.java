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
public class TypeOfDevice {
    @Id
    private UUID typeOfDeviceId;

    private String typeName;

    @OneToMany(mappedBy = "typeOfDevice")
    private List<Device> devices;
}
