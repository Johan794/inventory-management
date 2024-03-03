package com.api.inventario.application.service;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.mapper.ManufacturerMapper;
import com.api.inventario.application.port.input.ManufacturerService;
import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.application.service.utils.ObjectValidator;
import com.api.inventario.domain.model.*;
import com.api.inventario.application.dto.inputDto.ManufacturerInputDto;
import com.api.inventario.application.dto.outputDto.ManufacturerOutDto;
import com.api.inventario.application.specifications.DeviceModelSpecification;
import com.api.inventario.application.specifications.DeviceSpecification;
import com.api.inventario.application.specifications.ManufacturerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import static com.api.inventario.application.constant.SateIds.ACTIVE_ID;
import static com.api.inventario.application.exception.util.ExceptionUtils.throwException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl  implements ManufacturerService {
    private final LoadPort<Manufacturer> manufacturerLoadPort;
    private final UpdatePort<Manufacturer> manufacturerUpdatePort;
    private final ManufacturerMapper manufacturerMapper;
    private final ObjectValidator<Manufacturer> objectValidator;

    private final LoadPort<SystemState> systemStateLoadPort;
    private final UpdatePort<SystemState> systemStateUpdatePort;

    private final LoadPort<Device> deviceLoadPort;
    private final UpdatePort<Device> deviceUpdatePort;

    private final LoadPort<DeviceModel> deviceModelLoadPort;


    private final UpdatePort<DeviceModelManufacturer> deviceModelManufacturerUpdatePort;


    @Override
    public ManufacturerOutDto createManufacturer(ManufacturerInputDto manufacturerInputDto) {
        if (objectValidator.checkIfExistByName(ManufacturerSpecification.getByName(manufacturerInputDto.getManufacturerName()), manufacturerLoadPort) != null) {
            throwException("Error creating Manufacturer", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }

        List<DeviceModel> models = checkExistingModels(manufacturerInputDto.getModels());

        if (models.isEmpty()) {
            throwException("You can not create a manufacturer without models", HttpStatus.BAD_REQUEST, ErrorCode.ERROR_DEPENDENCIES);
        }

        Manufacturer manufacturer = manufacturerMapper.manufacturerFromManufacturerInputDto(manufacturerInputDto);
        return manufacturerMapper.manufacturerOutDtoFromManufacturer(buildRelations(cleanDevices(manufacturer.getDevices()),manufacturer,models));
    }

    @Override
    public ManufacturerOutDto updateManufacturer(ManufacturerInputDto manufacturerInputDto) {
        if (objectValidator.checkIfExistByName(ManufacturerSpecification.getByName(manufacturerInputDto.getManufacturerName()), manufacturerLoadPort) == null) {
            throwException("Error updating area", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }
        return manufacturerMapper.manufacturerOutDtoFromManufacturer(manufacturerUpdatePort.update(manufacturerMapper.manufacturerFromManufacturerInputDto(manufacturerInputDto)));
    }

    @Override
    public ManufacturerOutDto deleteManufacturer(String manufacturerId) {
        if(objectValidator.checkIfExistById(manufacturerId,manufacturerLoadPort)==null){
            throwException("Error deleting the manufacturer",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return manufacturerMapper.manufacturerOutDtoFromManufacturer(manufacturerUpdatePort.delete(manufacturerLoadPort.getById(manufacturerId)));
    }

    @Override
    public ManufacturerOutDto getManufacturer(String manufacturerId) {
        if(objectValidator.checkIfExistById(manufacturerId,manufacturerLoadPort)==null){
            throwException("Error getting the manufacturer",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return manufacturerMapper.manufacturerOutDtoFromManufacturer(manufacturerLoadPort.getById(manufacturerId));
    }

    @Override
    public List<ManufacturerOutDto> getAllManufacturers() {
        return manufacturerLoadPort.getAll().stream().map(manufacturerMapper::manufacturerOutDtoFromManufacturer).collect(Collectors.toList());
    }

    private List<Device> cleanDevices(List<Device> devices){
        return devices.stream()
                .filter(device -> deviceLoadPort.getByCriteria(DeviceSpecification.getByDeviceName(device.getName()))!=null)
                .distinct()
                .collect(Collectors.toList());
    }

    private Manufacturer buildRelations(List<Device> devices,Manufacturer manufacturer , List<DeviceModel> models){
        SystemState currentSystemState = systemStateLoadPort.getById(ACTIVE_ID);
        manufacturer.setManufacturerId(UUID.randomUUID());
        manufacturer.setDevices(devices);
        manufacturer.setSystemState(currentSystemState);
        manufacturerUpdatePort.save(manufacturer);

        devices.forEach(device -> {
                    device.setManufacturer(manufacturer);
                    deviceUpdatePort.save(device);
                });

        models.forEach(model -> deviceModelManufacturerUpdatePort
                .save(DeviceModelManufacturer.builder()
                        .id(DeviceModelManufacturerPK.builder()
                                .manufacturer(manufacturer)
                                .deviceModel(model)
                                .build())
                .build()));



        currentSystemState.getManufacturers().add(manufacturer);
        systemStateUpdatePort.save(currentSystemState);

        return manufacturer;
    }

    private List<DeviceModel> checkExistingModels(List<String> models){
        return models.stream()
                .filter(model -> deviceModelLoadPort.getByCriteria(DeviceModelSpecification.getByDeviceName(model))!=null)
                .distinct()
                .map(model -> deviceModelLoadPort.getByCriteria(DeviceModelSpecification.getByDeviceName(model)))
                .collect(Collectors.toList());
    }
}
