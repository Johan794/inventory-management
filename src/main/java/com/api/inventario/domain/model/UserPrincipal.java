package com.api.inventario.domain.model;

import jakarta.annotation.Nullable;
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
public class UserPrincipal {
    @Id
    private UUID userId;

    private String userType;

    private String idNumber;

    private String name;

    @Nullable
    private String secondName;


    private String firstLastName;

    @Nullable
    private String secondLastName;


    private String email;

    private String phone;

    private String userName;

    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Device> devices;

    @ManyToOne()
    @JoinColumn(name = "area_area_id")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "system_state_sate_id")
    private SystemState systemState;

}
