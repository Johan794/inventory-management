package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.port.input.DeviceService;
import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.application.dto.inputDto.DeviceInputDto;
import com.api.inventario.application.dto.outputDto.DeviceOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/device")
@RestController
@RequiredArgsConstructor
public class DeviceController implements CrudApi<DeviceInputDto, DeviceOutDto> {
    private final DeviceService deviceService;

    @Override
    public DeviceOutDto create(DeviceInputDto dto) {
        return deviceService.createDevice(dto);
    }

    @Override
    public DeviceOutDto update(DeviceInputDto dto) {
        return deviceService.updateDevice(dto);
    }

    @Override
    public DeviceOutDto delete(String Id) {
        return deviceService.deleteDevice(Id);
    }

    @Override
    public DeviceOutDto getById(String id) {
        return deviceService.getDevice(id);
    }

    @Override
    public List<DeviceOutDto> getAll() {
        return deviceService.getDevices();
    }
}
