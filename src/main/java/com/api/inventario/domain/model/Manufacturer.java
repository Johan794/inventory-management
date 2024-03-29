package com.api.inventario.domain.model;

import jakarta.persistence.*;
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
    private UUID manufacturerId;

    private String manufacturerName;

    @OneToMany(mappedBy = "manufacturer")
    private  List<Device> devices;

    @ManyToOne
    @JoinColumn(name = "system_state_sate_id")
    private SystemState systemState;



}
