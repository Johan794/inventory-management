package com.api.inventario.domain.model;

import com.api.inventario.domain.constant.SystemSateEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemState  extends  State{
    @Enumerated(EnumType.STRING)
    private SystemSateEnum state;

    @OneToMany(mappedBy = "systemState")
    private List<UserPrincipal> userPrincipalList;

    @OneToMany(mappedBy = "systemState")
    private List<Area> areas;

    @OneToMany(mappedBy = "systemState")
    private List<Manufacturer> manufacturers;

}
