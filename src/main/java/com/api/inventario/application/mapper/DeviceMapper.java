package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Device;
import com.api.inventario.infrastructure.dto.inputDto.DeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    Device deviceFromDeviceInputDto(DeviceInputDto deviceInputDto);
    DeviceOutDto deviceOutDtoFromDevice(Device device);
}
