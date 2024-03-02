package com.api.inventario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceState extends State{

    private String stateDescription;

    @OneToMany(mappedBy = "deviceState")
    private List<Device> devices;

}
