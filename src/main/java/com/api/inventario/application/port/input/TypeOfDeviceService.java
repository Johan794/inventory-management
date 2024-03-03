package com.api.inventario.application.port.input;

import com.api.inventario.application.dto.inputDto.TypeOfDeviceInputDto;
import com.api.inventario.application.dto.outputDto.TypeOfDeviceOutDto;

import java.util.List;

public interface TypeOfDeviceService {
    TypeOfDeviceOutDto createTypeOfDevice(TypeOfDeviceInputDto dto);

    TypeOfDeviceOutDto updateTypeOfDevice(TypeOfDeviceInputDto dto);

    TypeOfDeviceOutDto deleteTypeOfDevice(String typeId);

    TypeOfDeviceOutDto getTypeOfDevice(String typeId);

    List<TypeOfDeviceOutDto> getAllTypesOfDevice();


}
