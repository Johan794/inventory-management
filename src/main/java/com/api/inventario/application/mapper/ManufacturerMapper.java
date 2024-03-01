package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Manufacturer;
import com.api.inventario.infrastructure.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.infrastructure.dto.outputDto.ManufacturerOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DeviceMapper.class ,StateMapper.class })
public interface ManufacturerMapper {
    @Mapping(target = "deviceModelManufacturers",source = "models",ignore = true)
    Manufacturer manufacturerFromManufacturerInputDto(ManufacturerInputDto manufacturerInputDto);
    ManufacturerOutDto manufacturerOutDtoFromManufacturer(Manufacturer manufacturer);
}
