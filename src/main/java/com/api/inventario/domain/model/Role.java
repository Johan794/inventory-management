package com.api.inventario.domain.model;

import com.api.inventario.application.constant.RoleScope;
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

    @Enumerated(EnumType.STRING)
    private RoleScope scope;

    @OneToMany(mappedBy = "role")
    List<UserPrincipal> userPrincipalList;
}
