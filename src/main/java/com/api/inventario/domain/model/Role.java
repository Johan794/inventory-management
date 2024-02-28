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
public class Role {
    @Id
    private UUID roleId;

    private String roleName;

    @OneToMany(mappedBy = "role")
    List<UserPrincipal> userPrincipalList;
}
