package com.api.inventario.application.service;

import com.api.inventario.application.port.input.DeviceService;
import com.api.inventario.infrastructure.dto.inputDto.DeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceOutDto;

import java.util.List;

public class DeviceServiceImpl implements DeviceService {
    @Override
    public DeviceOutDto createDevice(DeviceInputDto deviceInputDto) {
        return null;
    }

    @Override
    public DeviceOutDto updateDevice(DeviceInputDto deviceInputDto) {
        return null;
    }

    @Override
    public DeviceOutDto deleteDevice(String id) {
        return null;
    }

    @Override
    public DeviceOutDto getDevice(String deviceId) {
        return null;
    }

    @Override
    public List<DeviceOutDto> getDevices() {
        return null;
    }
}
