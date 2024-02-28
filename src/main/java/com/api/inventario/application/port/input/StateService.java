package com.api.inventario.application.port.input;

import com.api.inventario.infrastructure.dto.inputDto.DeviceSateInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceStateOutDto;

import java.util.List;

public interface StateService {
    DeviceStateOutDto createDeviceSate(DeviceSateInputDto dto);

    //TODO averiguar para que se actualice en cascada
    DeviceStateOutDto updateDeviceSate(DeviceSateInputDto dto);

    DeviceStateOutDto deleteDeviceSate(String stateId);

    DeviceStateOutDto getDeviceSate(String stateId);

    List<DeviceStateOutDto> getAllDeviceSates();

    Object disableFromSysrem(Object objectToBeDisabled);
}
