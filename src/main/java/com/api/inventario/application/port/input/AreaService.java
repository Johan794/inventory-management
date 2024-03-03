package com.api.inventario.application.port.input;

import com.api.inventario.application.dto.inputDto.AreaInputDto;
import com.api.inventario.application.dto.outputDto.AreaOutDto;

import java.util.List;

public interface AreaService {
    AreaOutDto createArea(AreaInputDto dto);

    AreaOutDto updateArea(AreaInputDto dto);

    AreaOutDto deleteArea(String areaId);

    AreaOutDto getArea(String areaId);

    List<AreaOutDto> getAllAreas();
}
