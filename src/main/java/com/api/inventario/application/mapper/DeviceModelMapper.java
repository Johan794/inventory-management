package com.api.inventario.application.mapper;
import com.api.inventario.domain.model.DeviceModel;
import com.api.inventario.application.dto.inputDto.DeviceModelInputDto;
import com.api.inventario.application.dto.outputDto.DeviceModeOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceModelMapper {

    DeviceModel deviceModelFromDeviceModelInputDto(DeviceModelInputDto deviceModelInputDto);
    DeviceModeOutDto deviceModelOutDtoFromDeviceModel(DeviceModel deviceModel);



}
