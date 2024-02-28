package com.api.inventario.domain.model;

import com.api.inventario.domain.constant.SystemSateEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemState  extends  State{
    @Enumerated(EnumType.STRING)
    private SystemSateEnum state;
}
