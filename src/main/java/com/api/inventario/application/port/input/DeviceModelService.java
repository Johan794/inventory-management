package com.api.inventario.application.port.input;

import com.api.inventario.infrastructure.dto.inputDto.DeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceModeOutDto;

import java.util.List;

public interface DeviceModelService {
    DeviceModeOutDto createDeviceModel(DeviceInputDto deviceInputDto);
    DeviceModeOutDto updateDeviceModel(DeviceInputDto deviceInputDto);
    DeviceModeOutDto deleteDeviceModel(String deviceModelId);

    DeviceModeOutDto getDeviceModel(String deviceModelId);
    List<DeviceModeOutDto> getAllDeviceModel();
}
