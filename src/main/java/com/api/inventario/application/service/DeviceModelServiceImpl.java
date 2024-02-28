package com.api.inventario.application.service;

import com.api.inventario.application.port.input.DeviceModelService;
import com.api.inventario.infrastructure.dto.inputDto.DeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceModeOutDto;

import java.util.List;

public class DeviceModelServiceImpl implements DeviceModelService {

    @Override
    public DeviceModeOutDto createDeviceModel(DeviceInputDto deviceInputDto) {
        return null;
    }

    @Override
    public DeviceModeOutDto updateDeviceModel(DeviceInputDto deviceInputDto) {
        return null;
    }

    @Override
    public DeviceModeOutDto deleteDeviceModel(String deviceModelId) {
        return null;
    }

    @Override
    public DeviceModeOutDto getDeviceModel(String deviceModelId) {
        return null;
    }

    @Override
    public List<DeviceModeOutDto> getAllDeviceModel() {
        return null;
    }
}
