package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.DeviceState;
import com.api.inventario.domain.model.State;
import com.api.inventario.infrastructure.dto.inputDto.DeviceInputDto;
import com.api.inventario.infrastructure.dto.inputDto.DeviceSateInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceStateOutDto;
import com.api.inventario.infrastructure.dto.outputDto.SystemStateOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {
    DeviceStateOutDto deviceStateOutDtoFromState (State state);
    SystemStateOutDto systemStateOutDtoFromState (State state);
    DeviceState deviceStateFromDeviceStateInputDto(DeviceSateInputDto deviceSateInputDto);

}
