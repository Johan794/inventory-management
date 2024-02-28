package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Manufacturer;
import com.api.inventario.infrastructure.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.infrastructure.dto.outputDto.ManufacturerOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    Manufacturer manufacturerFromManufacturerInputDto(ManufacturerInputDto manufacturerInputDto);
    ManufacturerOutDto manufacturerOutDtoFromManufacturer(Manufacturer manufacturer);
}
