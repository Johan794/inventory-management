package com.api.inventario.infrastructure.adapter.rest.controller;


import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.DeviceModelInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceModeOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/deviceModel")
@RestController
public class DeviceModelController implements CrudApi<DeviceModelInputDto, DeviceModeOutDto> {
    @Override
    public DeviceModeOutDto create(DeviceModelInputDto dto) {
        return null;
    }

    @Override
    public DeviceModeOutDto update(DeviceModelInputDto dto) {
        return null;
    }

    @Override
    public DeviceModeOutDto delete(String Id) {
        return null;
    }

    @Override
    public DeviceModeOutDto getById(String id) {
        return null;
    }

    @Override
    public List<DeviceModeOutDto> getAll() {
        return null;
    }
}
