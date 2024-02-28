package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.infrastructure.dto.outputDto.ManufacturerOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController implements CrudApi<ManufacturerInputDto, ManufacturerOutDto> {

    @Override
    public ManufacturerOutDto create(ManufacturerInputDto dto) {
        return null;
    }

    @Override
    public ManufacturerOutDto update(ManufacturerInputDto dto) {
        return null;
    }

    @Override
    public ManufacturerOutDto delete(String id) {
        return null;
    }

    @Override
    public ManufacturerOutDto getById(String id) {
        return null;
    }

    @Override
    public List<ManufacturerOutDto> getAll() {
        return null;
    }
}
