package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.DeviceState;
import com.api.inventario.domain.model.State;
import com.api.inventario.application.dto.inputDto.DeviceSateInputDto;
import com.api.inventario.application.dto.outputDto.DeviceStateOutDto;
import com.api.inventario.application.dto.outputDto.SystemStateOutDto;
import com.api.inventario.domain.model.SystemState;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {
    DeviceStateOutDto deviceStateOutDtoFromState (DeviceState state);
    SystemStateOutDto systemStateOutDtoFromState (SystemState state);
    DeviceState deviceStateFromDeviceStateInputDto(DeviceSateInputDto deviceSateInputDto);

}
