package com.api.inventario.application.mapper;
import com.api.inventario.domain.model.DeviceModel;
import com.api.inventario.infrastructure.dto.inputDto.DeviceModelInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceModeOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeviceModelMapper {

    DeviceModel deviceModelFromDeviceModelInputDto(DeviceModelInputDto deviceModelInputDto);
    DeviceModeOutDto deviceModelOutDtoFromDeviceModel(DeviceModel deviceModel);



}
