package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.DeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/device")
@RestController
public class DeviceController implements CrudApi<DeviceInputDto, DeviceOutDto> {

    @Override
    public DeviceOutDto create(DeviceInputDto dto) {
        return null;
    }

    @Override
    public DeviceOutDto update(DeviceInputDto dto) {
        return null;
    }

    @Override
    public DeviceOutDto delete(String Id) {
        return null;
    }

    @Override
    public DeviceOutDto getById(String id) {
        return null;
    }

    @Override
    public List<DeviceOutDto> getAll() {
        return null;
    }
}
