package com.api.inventario.domain.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceState extends State{

    private String stateDescription;

}
