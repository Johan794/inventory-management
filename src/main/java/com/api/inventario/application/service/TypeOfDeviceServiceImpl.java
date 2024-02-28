package com.api.inventario.application.service;

import com.api.inventario.application.port.input.TypeOfDeviceService;
import com.api.inventario.infrastructure.dto.inputDto.TypeOfDeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.TypeOfDeviceOutDto;

import java.util.List;

public class TypeOfDeviceServiceImpl implements TypeOfDeviceService {
    @Override
    public TypeOfDeviceOutDto createTypeOfDevice(TypeOfDeviceInputDto dto) {
        return null;
    }

    @Override
    public TypeOfDeviceOutDto updateTypeOfDevice(TypeOfDeviceInputDto dto) {
        return null;
    }

    @Override
    public TypeOfDeviceOutDto deleteTypeOfDevice(String typeId) {
        return null;
    }

    @Override
    public TypeOfDeviceOutDto getTypeOfDevice(String typeId) {
        return null;
    }

    @Override
    public List<TypeOfDeviceOutDto> getAllTypesOfDevice() {
        return null;
    }
}
