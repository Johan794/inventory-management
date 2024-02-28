package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.DeviceSateInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceStateOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class SateController implements CrudApi<DeviceSateInputDto, DeviceStateOutDto> {
    
    @Override
    public DeviceStateOutDto create(DeviceSateInputDto dto) {
        return null;
    }

    @Override
    public DeviceStateOutDto update(DeviceSateInputDto dto) {
        return null;
    }

    @Override
    public DeviceStateOutDto delete(String id) {
        return null;
    }

    @Override
    public DeviceStateOutDto getById(String id) {
        return null;
    }

    @Override
    public List<DeviceStateOutDto> getAll() {
        return null;
    }
}
