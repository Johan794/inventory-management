package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.AreaInputDto;
import com.api.inventario.infrastructure.dto.outputDto.AreaOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/area")
@RestController
public class AreaController  implements CrudApi<AreaInputDto , AreaOutDto> {

    @Override
    public AreaOutDto create(AreaInputDto dto) {
        return null;
    }

    @Override
    public AreaOutDto update(AreaInputDto dto) {
        return null;
    }

    @Override
    public AreaOutDto delete(String id) {
        return null;
    }


    @Override
    public AreaOutDto getById(String id) {
        return null;
    }

    @Override
    public List<AreaOutDto> getAll() {
        return null;
    }
}
