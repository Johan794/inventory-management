package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Area;
import com.api.inventario.application.dto.inputDto.AreaInputDto;
import com.api.inventario.application.dto.outputDto.AreaOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {UserMapper.class, StateMapper.class})
public interface AreaMapper {
    Area areaFromAreaInputDto(AreaInputDto areaInputDto);
    AreaOutDto areaOutDtoFromArea(Area area);
}
