package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.port.input.AreaService;
import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.application.dto.inputDto.AreaInputDto;
import com.api.inventario.application.dto.outputDto.AreaOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/area")
@RestController
@RequiredArgsConstructor
public class AreaController  implements CrudApi<AreaInputDto , AreaOutDto> {
    private final AreaService areaService;

    @Override
    public AreaOutDto create(AreaInputDto dto) {
        return areaService.createArea(dto);
    }

    @Override
    public AreaOutDto update(AreaInputDto dto) {
        return areaService.updateArea(dto);
    }

    @Override
    public AreaOutDto delete(String id) {
        return areaService.deleteArea(id);
    }


    @Override
    public AreaOutDto getById(String id) {
        return areaService.getArea(id);
    }

    @Override
    public List<AreaOutDto> getAll() {
        return areaService.getAllAreas();
    }
}
