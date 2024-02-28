package com.api.inventario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    @Id
    private UUID areaId;

    @NotBlank
    private String areaName;

    @OneToMany(mappedBy = "area")
    private List<UserPrincipal> areaUsers;




}
