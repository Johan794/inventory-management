package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.TypeOfDevice;
import com.api.inventario.infrastructure.dto.inputDto.TypeOfDeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.TypeOfDeviceOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeOfDeviceMapper {
    TypeOfDevice typeOfDeviceFromTypeOfDeviceInputDto(TypeOfDeviceInputDto typeOfDeviceInputDto);

    TypeOfDeviceOutDto typeOfDeviceOutDtoFromTypeOfDevice(TypeOfDevice typeOfDevice);
}
