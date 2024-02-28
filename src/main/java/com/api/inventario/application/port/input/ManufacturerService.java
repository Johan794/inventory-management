package com.api.inventario.application.port.input;

import com.api.inventario.infrastructure.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.infrastructure.dto.outputDto.ManufacturerOutDto;

import java.util.List;

public interface ManufacturerService {
    ManufacturerOutDto createManufacturer(ManufacturerInputDto manufacturerInputDto);

    ManufacturerOutDto updateManufacturer(ManufacturerInputDto manufacturerInputDto);

    ManufacturerOutDto deleteManufacturer(String manufacturerId);

    ManufacturerOutDto getManufacturer(String manufacturerId);

    List<ManufacturerOutDto> getAllManufacturers();
}
