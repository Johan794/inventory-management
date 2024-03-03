package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.TypeOfDevice;
import com.api.inventario.application.dto.inputDto.TypeOfDeviceInputDto;
import com.api.inventario.application.dto.outputDto.TypeOfDeviceOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DeviceMapper.class})
public interface TypeOfDeviceMapper {
    TypeOfDevice typeOfDeviceFromTypeOfDeviceInputDto(TypeOfDeviceInputDto typeOfDeviceInputDto);

    TypeOfDeviceOutDto typeOfDeviceOutDtoFromTypeOfDevice(TypeOfDevice typeOfDevice);
}
