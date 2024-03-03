package com.api.inventario.application.service;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.mapper.DeviceModelMapper;
import com.api.inventario.application.port.input.DeviceModelService;
import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.application.service.utils.ObjectValidator;
import com.api.inventario.domain.model.DeviceModel;
import com.api.inventario.domain.model.DeviceModelManufacturer;
import com.api.inventario.domain.model.DeviceModelManufacturerPK;
import com.api.inventario.domain.model.Manufacturer;
import com.api.inventario.application.dto.inputDto.DeviceModelInputDto;
import com.api.inventario.application.dto.outputDto.DeviceModeOutDto;
import com.api.inventario.application.specifications.DeviceModelSpecification;
import com.api.inventario.application.specifications.ManufacturerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import static com.api.inventario.application.exception.util.ExceptionUtils.throwException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceModelServiceImpl implements DeviceModelService {
    private final LoadPort<DeviceModel> deviceModelLoadPort;
    private final LoadPort<Manufacturer> manufacturerLoadPort;
    private final UpdatePort<DeviceModel> deviceModelUpdatePort;
    private final UpdatePort<DeviceModelManufacturer> deviceModelManufacturerUpdatePort;
    private final DeviceModelMapper deviceModelMapper;
    private final ObjectValidator<DeviceModel> deviceModelObjectValidator;

    @Override
    public DeviceModeOutDto createDeviceModel(DeviceModelInputDto deviceInputDto) {
        if(deviceModelObjectValidator.checkIfExistByName(DeviceModelSpecification.getByDeviceName(deviceInputDto.getModelName()),deviceModelLoadPort)!=null){
            throwException("Error creating Device model", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }

        List<String> manufacturers = checkExistingManufacturer(List.of(deviceInputDto.getManufacturerNames().split(",")));

        if(manufacturers.isEmpty()){
            throwException("You can not create a device model without manufacturer/s",HttpStatus.BAD_REQUEST,ErrorCode.ERROR_DEPENDENCIES);
        }

        DeviceModel deviceModel = deviceModelMapper.deviceModelFromDeviceModelInputDto(deviceInputDto);
        deviceModel.setDeviceModelId(UUID.randomUUID());
        deviceModelUpdatePort.save(deviceModel);
        buildRelations(manufacturers,deviceModel);
        return deviceModelMapper.deviceModelOutDtoFromDeviceModel(deviceModel);
    }

    @Override
    public DeviceModeOutDto updateDeviceModel(DeviceModelInputDto deviceInputDto) {
        if(deviceModelObjectValidator.checkIfExistByName(DeviceModelSpecification.getByDeviceName(deviceInputDto.getModelName()),deviceModelLoadPort)==null){
            throwException("Error updating the Device model",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return deviceModelMapper.deviceModelOutDtoFromDeviceModel(deviceModelUpdatePort.save(deviceModelMapper.deviceModelFromDeviceModelInputDto(deviceInputDto)));
    }

    @Override
    public DeviceModeOutDto deleteDeviceModel(String deviceModelId) {
        if(deviceModelObjectValidator.checkIfExistById(deviceModelId,deviceModelLoadPort) == null){
            throwException("Error deleting the device model",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return deviceModelMapper.deviceModelOutDtoFromDeviceModel(deviceModelUpdatePort.delete(deviceModelLoadPort.getById(deviceModelId)));
    }

    @Override
    public DeviceModeOutDto getDeviceModel(String deviceModelId) {
        if(deviceModelObjectValidator.checkIfExistById(deviceModelId,deviceModelLoadPort) == null){
            throwException("Error getting the device model",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return deviceModelMapper.deviceModelOutDtoFromDeviceModel(deviceModelLoadPort.getById(deviceModelId));

    }

    @Override
    public List<DeviceModeOutDto> getAllDeviceModel() {
        return deviceModelLoadPort.getAll().stream().map(deviceModelMapper::deviceModelOutDtoFromDeviceModel).collect(Collectors.toList());
    }

    private List<String> checkExistingManufacturer(List<String> manufacturers){
        return manufacturers.
                stream()
                .filter(name -> manufacturerLoadPort.getByCriteria(ManufacturerSpecification.getByName(name))!=null)
                .distinct()
                .collect(Collectors.toList());

    }

    private void buildRelations(List<String> manufacturers, DeviceModel deviceModel){
        List<Manufacturer> manufacturersList = manufacturers.stream()
                .map(manufacturer -> manufacturerLoadPort.getByCriteria(ManufacturerSpecification.getByName(manufacturer)))
                .toList();

        manufacturersList.forEach(manufacturer -> deviceModelManufacturerUpdatePort.save(DeviceModelManufacturer
                .builder()
                .id(DeviceModelManufacturerPK.builder()
                        .deviceModel(deviceModel)
                        .manufacturer(manufacturer)
                        .build())
                .build()));


    }
}
