package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.port.input.ManufacturerService;
import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.application.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.application.dto.outputDto.ManufacturerOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
@RequiredArgsConstructor
public class ManufacturerController implements CrudApi<ManufacturerInputDto, ManufacturerOutDto> {
    private final ManufacturerService manufacturerService;

    @Override
    public ManufacturerOutDto create(ManufacturerInputDto dto) {
        return manufacturerService.createManufacturer(dto);
    }

    @Override
    public ManufacturerOutDto update(ManufacturerInputDto dto) {
        return manufacturerService.updateManufacturer(dto);
    }

    @Override
    public ManufacturerOutDto delete(String id) {
        return manufacturerService.deleteManufacturer(id);
    }

    @Override
    public ManufacturerOutDto getById(String id) {
        return manufacturerService.getManufacturer(id);
    }

    @Override
    public List<ManufacturerOutDto> getAll() {
        return manufacturerService.getAllManufacturers();
    }
}
