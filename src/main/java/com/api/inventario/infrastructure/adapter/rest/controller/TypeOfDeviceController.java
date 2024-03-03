package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.application.port.input.TypeOfDeviceService;
import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.application.dto.inputDto.TypeOfDeviceInputDto;
import com.api.inventario.application.dto.outputDto.TypeOfDeviceOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typeOfDevice")
@RequiredArgsConstructor
public class TypeOfDeviceController implements CrudApi<TypeOfDeviceInputDto, TypeOfDeviceOutDto> {
    private final TypeOfDeviceService typeOfDeviceService;
    @Override
    public TypeOfDeviceOutDto create(TypeOfDeviceInputDto dto) {
        return typeOfDeviceService.createTypeOfDevice(dto);
    }

    @Override
    public TypeOfDeviceOutDto update(TypeOfDeviceInputDto dto) {
        return typeOfDeviceService.updateTypeOfDevice(dto);
    }

    @Override
    public TypeOfDeviceOutDto delete(String id) {
        return typeOfDeviceService.deleteTypeOfDevice(id);
    }

    @Override
    public TypeOfDeviceOutDto getById(String id) {
        return typeOfDeviceService.getTypeOfDevice(id);
    }

    @Override
    public List<TypeOfDeviceOutDto> getAll() {
        return typeOfDeviceService.getAllTypesOfDevice();
    }
}
