package com.api.inventario.application.port.input;

import com.api.inventario.infrastructure.dto.inputDto.DeviceModelInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceModeOutDto;

import java.util.List;

public interface DeviceModelService {
    DeviceModeOutDto createDeviceModel(DeviceModelInputDto deviceInputDto);
    DeviceModeOutDto updateDeviceModel(DeviceModelInputDto deviceInputDto);
    DeviceModeOutDto deleteDeviceModel(String deviceModelId);

    DeviceModeOutDto getDeviceModel(String deviceModelId);
    List<DeviceModeOutDto> getAllDeviceModel();
}
