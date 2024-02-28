package com.api.inventario.application.service;

import com.api.inventario.application.port.input.AreaService;
import com.api.inventario.infrastructure.dto.inputDto.AreaInputDto;
import com.api.inventario.infrastructure.dto.outputDto.AreaOutDto;

import java.util.List;

public class AreaServiceImpl implements AreaService {
    @Override
    public AreaOutDto createArea(AreaInputDto dto) {
        return null;
    }

    @Override
    public AreaOutDto updateArea(AreaInputDto dto) {
        return null;
    }

    @Override
    public AreaOutDto deleteArea(String areaId) {
        return null;
    }

    @Override
    public AreaOutDto getArea(String areaId) {
        return null;
    }

    @Override
    public List<AreaOutDto> getAllAreas() {
        return null;
    }
}
