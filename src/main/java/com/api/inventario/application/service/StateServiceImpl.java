package com.api.inventario.application.service;

import com.api.inventario.application.port.input.StateService;
import com.api.inventario.infrastructure.dto.inputDto.DeviceSateInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceStateOutDto;

import java.util.List;

public class StateServiceImpl implements StateService {
    @Override
    public DeviceStateOutDto createDeviceSate(DeviceSateInputDto dto) {
        return null;
    }

    @Override
    public DeviceStateOutDto updateDeviceSate(DeviceSateInputDto dto) {
        return null;
    }

    @Override
    public DeviceStateOutDto deleteDeviceSate(String stateId) {
        return null;
    }

    @Override
    public DeviceStateOutDto getDeviceSate(String stateId) {
        return null;
    }

    @Override
    public List<DeviceStateOutDto> getAllDeviceSates() {
        return null;
    }

    @Override
    public Object disableFromSysrem(Object objectToBeDisabled) {
        return null;
    }
}
