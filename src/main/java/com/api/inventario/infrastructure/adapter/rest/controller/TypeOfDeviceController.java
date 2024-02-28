package com.api.inventario.infrastructure.adapter.rest.controller;

import com.api.inventario.infrastructure.adapter.rest.api.CrudApi;
import com.api.inventario.infrastructure.dto.inputDto.TypeOfDeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.TypeOfDeviceOutDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typeOfDevice")
public class TypeOfDeviceController implements CrudApi<TypeOfDeviceInputDto, TypeOfDeviceOutDto> {
    @Override
    public TypeOfDeviceOutDto create(TypeOfDeviceInputDto dto) {
        return null;
    }

    @Override
    public TypeOfDeviceOutDto update(TypeOfDeviceInputDto dto) {
        return null;
    }

    @Override
    public TypeOfDeviceOutDto delete(String id) {
        return null;
    }

    @Override
    public TypeOfDeviceOutDto getById(String id) {
        return null;
    }

    @Override
    public List<TypeOfDeviceOutDto> getAll() {
        return null;
    }
}
