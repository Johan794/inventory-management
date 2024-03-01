package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Area;
import com.api.inventario.infrastructure.dto.inputDto.AreaInputDto;
import com.api.inventario.infrastructure.dto.outputDto.AreaOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {UserMapper.class, StateMapper.class})
public interface AreaMapper {
    Area areaFromAreaInputDto(AreaInputDto areaInputDto);
    AreaOutDto areaOutDtoFromArea(Area area);
}
