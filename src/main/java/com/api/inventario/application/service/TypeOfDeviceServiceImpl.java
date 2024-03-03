package com.api.inventario.application.service;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.mapper.TypeOfDeviceMapper;
import com.api.inventario.application.port.input.TypeOfDeviceService;
import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.application.service.utils.ObjectValidator;
import com.api.inventario.domain.model.TypeOfDevice;
import com.api.inventario.application.dto.inputDto.TypeOfDeviceInputDto;
import com.api.inventario.application.dto.outputDto.TypeOfDeviceOutDto;
import com.api.inventario.application.specifications.TypeOfDeviceSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.api.inventario.application.exception.util.ExceptionUtils.throwException;
@Service
@RequiredArgsConstructor
public class TypeOfDeviceServiceImpl implements TypeOfDeviceService {
    private final LoadPort<TypeOfDevice> typeOfDeviceLoadPort;
    private final UpdatePort<TypeOfDevice> typeOfDeviceUpdatePort;
    private final TypeOfDeviceMapper typeOfDeviceMapper;
    private final ObjectValidator<TypeOfDevice> objectValidator;

    @Transactional
    @Override
    public TypeOfDeviceOutDto createTypeOfDevice(TypeOfDeviceInputDto dto) {
        if(objectValidator.checkIfExistByName(TypeOfDeviceSpecification.getByTypeName(dto.getTypeName()),typeOfDeviceLoadPort)!=null){
            throwException("Error creating type", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }
        TypeOfDevice typeOfDeviceToSave = typeOfDeviceMapper.typeOfDeviceFromTypeOfDeviceInputDto(dto);
        typeOfDeviceToSave.setTypeOfDeviceId(UUID.randomUUID());
        typeOfDeviceToSave.setDevices(new ArrayList<>());
        typeOfDeviceUpdatePort.save(typeOfDeviceToSave);
        return typeOfDeviceMapper.typeOfDeviceOutDtoFromTypeOfDevice(typeOfDeviceToSave);
    }

    @Transactional
    @Override
    public TypeOfDeviceOutDto updateTypeOfDevice(TypeOfDeviceInputDto dto) {
        if(objectValidator.checkIfExistByName(TypeOfDeviceSpecification.getByTypeName(dto.getTypeName()),typeOfDeviceLoadPort)!=null){
            throwException("Error updating type", HttpStatus.NOT_FOUND, ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }

        return typeOfDeviceMapper.typeOfDeviceOutDtoFromTypeOfDevice(typeOfDeviceUpdatePort
                .update(typeOfDeviceLoadPort.getByCriteria(TypeOfDeviceSpecification.getByTypeName(dto.getTypeName()))));
    }

    @Transactional
    @Override
    public TypeOfDeviceOutDto deleteTypeOfDevice(String typeId) {
        if(objectValidator.checkIfExistById(typeId,typeOfDeviceLoadPort)==null){
            throwException("Error deleting type", HttpStatus.NOT_FOUND, ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return typeOfDeviceMapper.typeOfDeviceOutDtoFromTypeOfDevice(typeOfDeviceUpdatePort.delete(typeOfDeviceLoadPort.getById(typeId)));
    }

    @Transactional
    @Override
    public TypeOfDeviceOutDto getTypeOfDevice(String typeId) {
        if(objectValidator.checkIfExistById(typeId,typeOfDeviceLoadPort)==null){
            throwException("Error getting type", HttpStatus.NOT_FOUND, ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return null;
    }

    @Transactional
    @Override
    public List<TypeOfDeviceOutDto> getAllTypesOfDevice() {
        return typeOfDeviceLoadPort.getAll().stream().map(typeOfDeviceMapper::typeOfDeviceOutDtoFromTypeOfDevice).collect(Collectors.toList());
    }
}
