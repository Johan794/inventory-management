package com.api.inventario.domain.model;

import com.api.inventario.domain.model.security.Authorities;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_authorities",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authorities> authorities;
}
