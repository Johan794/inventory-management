package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.Device;
import com.api.inventario.application.dto.inputDto.DeviceInputDto;
import com.api.inventario.application.dto.outputDto.DeviceOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    @Mappings({
            @Mapping(target = "deviceState" , source = "deviceState",ignore = true),
            @Mapping(target = "typeOfDevice" , source = "typeOfDevice",ignore = true),
            @Mapping(target = "manufacturer" , source = "manufacturer",ignore = true),
            @Mapping(target = "user" , source = "user",ignore = true)
    })
    Device deviceFromDeviceInputDto(DeviceInputDto deviceInputDto);

    @Mappings({
            @Mapping(target = "deviceState" , expression = "java(device.getDeviceState().getStateDescription())"),
            @Mapping(target = "typeOfDevice" , expression = "java(device.getTypeOfDevice().getTypeName())"),
            @Mapping(target = "manufacturer" , expression = "java(device.getManufacturer().getManufacturerName())"),
            @Mapping(target = "user" , expression = "java(device.getUser().getUserName())")
    })
    DeviceOutDto deviceOutDtoFromDevice(Device device);


}
