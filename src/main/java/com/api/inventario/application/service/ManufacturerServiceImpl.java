package com.api.inventario.application.service;

import com.api.inventario.application.port.input.ManufacturerService;
import com.api.inventario.infrastructure.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.infrastructure.dto.outputDto.ManufacturerOutDto;

import java.util.List;

public class ManufacturerServiceImpl  implements ManufacturerService {

    @Override
    public ManufacturerOutDto createManufacturer(ManufacturerInputDto manufacturerInputDto) {
        return null;
    }

    @Override
    public ManufacturerOutDto updateManufacturer(ManufacturerInputDto manufacturerInputDto) {
        return null;
    }

    @Override
    public ManufacturerOutDto deleteManufacturer(String manufacturerId) {
        return null;
    }

    @Override
    public ManufacturerOutDto getManufacturer(String manufacturerId) {
        return null;
    }

    @Override
    public List<ManufacturerOutDto> getAllManufacturers() {
        return null;
    }
}
