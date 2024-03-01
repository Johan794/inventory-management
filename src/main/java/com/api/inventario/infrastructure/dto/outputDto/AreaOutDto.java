package com.api.inventario.infrastructure.dto.outputDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;


import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaOutDto {
    private UUID areaId;

    private String areaName;

    private List<UserOutDto> areaUsers;

    private SystemStateOutDto systemState;




}
