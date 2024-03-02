package com.api.inventario.application.service;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.mapper.DeviceMapper;
import com.api.inventario.application.port.input.DeviceService;
import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.application.service.utils.ObjectValidator;
import com.api.inventario.domain.model.*;
import com.api.inventario.infrastructure.dto.inputDto.DeviceInputDto;
import com.api.inventario.infrastructure.dto.outputDto.DeviceOutDto;
import com.api.inventario.infrastructure.repository.specifications.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.api.inventario.application.exception.util.ExceptionUtils.throwException;
@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final LoadPort<Device> deviceLoadPort;
    private final UpdatePort<Device> deviceUpdatePort;
    private  final DeviceMapper deviceMapper;
    private final ObjectValidator<Device> deviceObjectValidator;

    private final LoadPort<DeviceState> deviceStateLoadPort;
    private final UpdatePort<DeviceState> deviceStateUpdatePort;

    private final LoadPort<TypeOfDevice> typeOfDeviceLoadPort;
    private final UpdatePort<TypeOfDevice > typeOfDeviceUpdatePort;

    private final LoadPort<Manufacturer> manufacturerLoadPort;
    private final UpdatePort<Manufacturer> manufacturerUpdatePort;

    private final LoadPort<UserPrincipal> userPrincipalLoadPort;
    private final UpdatePort<UserPrincipal> userPrincipalUpdatePort;



    @Transactional
    @Override
    public DeviceOutDto createDevice(DeviceInputDto deviceInputDto) {
        if(deviceObjectValidator.checkIfExistByName(DeviceSpecification.getByDeviceName(deviceInputDto.getName()),deviceLoadPort)!=null){
            throwException("Error creating the Device ", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }
        Device deviceToSave = buildRelations(deviceInputDto.getDeviceState(),deviceInputDto.getTypeOfDevice(),deviceInputDto.getManufacturer(),deviceInputDto.getUser(),deviceMapper.deviceFromDeviceInputDto(deviceInputDto));
        deviceToSave.setDeviceID(UUID.randomUUID());

        return deviceMapper.deviceOutDtoFromDevice(deviceUpdatePort.save(deviceToSave));
    }

    @Override
    public DeviceOutDto updateDevice(DeviceInputDto deviceInputDto) {
        if(deviceObjectValidator.checkIfExistByName(DeviceSpecification.getByDeviceName(deviceInputDto.getName()),deviceLoadPort)==null){
            throwException("Error updating the Device ", HttpStatus.NOT_FOUND, ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        validateRefs(deviceInputDto.getDeviceState(),deviceInputDto.getTypeOfDevice(),deviceInputDto.getManufacturer(),deviceInputDto.getUser());
        return deviceMapper.deviceOutDtoFromDevice(deviceUpdatePort.update(deviceMapper.deviceFromDeviceInputDto(deviceInputDto)));
    }

    @Override
    public DeviceOutDto deleteDevice(String id) {
        if(deviceObjectValidator.checkIfExistById(id,deviceLoadPort)==null){
            throwException("Error deleting the device",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return deviceMapper.deviceOutDtoFromDevice(deviceUpdatePort.delete(deviceLoadPort.getById(id)));
    }

    @Override
    public DeviceOutDto getDevice(String deviceId) {
        if(deviceObjectValidator.checkIfExistById(deviceId,deviceLoadPort)==null){
            throwException("Error getting the device",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return deviceMapper.deviceOutDtoFromDevice(deviceLoadPort.getById(deviceId));
    }

    @Override
    public List<DeviceOutDto> getDevices() {
        return deviceLoadPort.getAll().stream().map(deviceMapper::deviceOutDtoFromDevice).collect(Collectors.toList());
    }

    private void validateRefs(String deviceState, String typeOfDevice,String  manufacturer ,String user ){
        boolean missingRef = (deviceStateLoadPort.getByCriteria(DeviceSateSpecification.getByDescription(deviceState))!=null)
                && (typeOfDeviceLoadPort.getByCriteria(TypeOfDeviceSpecification.getByTypeName(typeOfDevice))!=null)
                && (manufacturerLoadPort.getByCriteria(ManufacturerSpecification.getByName(manufacturer))!=null)
                && (userPrincipalLoadPort.getByCriteria(UserSpecification.geyByUserName(user))!=null);

        if(missingRef){
            throwException("Error,there are missing references needed for creating the Device ", HttpStatus.BAD_REQUEST, ErrorCode.ERROR_DEPENDENCIES);
        }
    }

    private Device buildRelations(String deviceStateRef, String typeOfDeviceRef,String  manufacturerRef ,String userRef, Device device){
        validateRefs(deviceStateRef,typeOfDeviceRef,manufacturerRef,userRef);

        DeviceState deviceState = deviceStateLoadPort.getByCriteria(DeviceSateSpecification.getByDescription(deviceStateRef));
        TypeOfDevice typeOfDevice = typeOfDeviceLoadPort.getByCriteria(TypeOfDeviceSpecification.getByTypeName(typeOfDeviceRef));
        Manufacturer manufacturer = manufacturerLoadPort.getByCriteria(ManufacturerSpecification.getByName(manufacturerRef));
        UserPrincipal user = userPrincipalLoadPort.getByCriteria(UserSpecification.geyByUserName(userRef));

        deviceState.getDevices().add(device);
        typeOfDevice.getDevices().add(device);
        manufacturer.getDevices().add(device);
        user.getDevices().add(device);

        device.setDeviceState(deviceState);
        device.setTypeOfDevice(typeOfDevice);
        device.setManufacturer(manufacturer);
        device.setUser(user);

        deviceStateUpdatePort.save(deviceState);
        typeOfDeviceUpdatePort.save(typeOfDevice);
        manufacturerUpdatePort.save(manufacturer);
        userPrincipalUpdatePort.save(user);
        return  device;

    }


}
