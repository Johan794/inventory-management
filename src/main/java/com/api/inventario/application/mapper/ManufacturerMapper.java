package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Manufacturer;
import com.api.inventario.application.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.application.dto.outputDto.ManufacturerOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DeviceMapper.class ,StateMapper.class })
public interface ManufacturerMapper {
    Manufacturer manufacturerFromManufacturerInputDto(ManufacturerInputDto manufacturerInputDto);
    ManufacturerOutDto manufacturerOutDtoFromManufacturer(Manufacturer manufacturer);
}
