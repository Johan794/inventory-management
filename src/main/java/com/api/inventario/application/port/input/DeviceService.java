package com.api.inventario.application.port.input;


import com.api.inventario.application.dto.inputDto.DeviceInputDto;
import com.api.inventario.application.dto.outputDto.DeviceOutDto;

import java.util.List;

public interface DeviceService {
    DeviceOutDto createDevice(DeviceInputDto deviceInputDto);

    DeviceOutDto updateDevice(DeviceInputDto deviceInputDto);

    DeviceOutDto deleteDevice(String id);

    DeviceOutDto getDevice(String deviceId);

    List<DeviceOutDto> getDevices();


}
