package com.api.inventario.domain.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceState extends State{

    private String stateDescription;

}
