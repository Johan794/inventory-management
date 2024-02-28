package com.api.inventario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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

    private String typeDescription;
}
