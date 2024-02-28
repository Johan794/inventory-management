package com.api.inventario.domain.model.security;

import com.api.inventario.domain.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {
    @Id
    private UUID id;

    private String authority;

    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> roles;

}
