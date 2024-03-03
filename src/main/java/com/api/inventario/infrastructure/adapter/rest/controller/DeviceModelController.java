package com.api.inventario.infrastructure.adapter.rest.controller;


import com.api.inventario.application.port.input.DeviceModelService;
import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.application.dto.inputDto.DeviceModelInputDto;
import com.api.inventario.application.dto.outputDto.DeviceModeOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/deviceModel")
@RestController
@RequiredArgsConstructor
public class DeviceModelController implements CrudApi<DeviceModelInputDto, DeviceModeOutDto> {
    private final DeviceModelService deviceModelService;
    @Override
    public DeviceModeOutDto create(DeviceModelInputDto dto) {
        return deviceModelService.createDeviceModel(dto);
    }

    @Override
    public DeviceModeOutDto update(DeviceModelInputDto dto) {
        return deviceModelService.updateDeviceModel(dto);
    }

    @Override
    public DeviceModeOutDto delete(String Id) {
        return deviceModelService.deleteDeviceModel(Id);
    }

    @Override
    public DeviceModeOutDto getById(String id) {
        return deviceModelService.getDeviceModel(id);
    }

    @Override
    public List<DeviceModeOutDto> getAll() {
        return deviceModelService.getAllDeviceModel();
    }
}
