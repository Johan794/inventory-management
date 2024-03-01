package com.api.inventario.application.service;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.error.ApplicationError;
import com.api.inventario.application.exception.ApplicationException;
import com.api.inventario.application.mapper.AreaMapper;
import com.api.inventario.application.port.input.AreaService;
import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Area;
import com.api.inventario.domain.model.SystemState;
import com.api.inventario.infrastructure.dto.inputDto.AreaInputDto;
import com.api.inventario.infrastructure.dto.outputDto.AreaOutDto;
import com.api.inventario.infrastructure.repository.specifications.AreaSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.api.inventario.application.constant.SateIds.ACTIVE_ID;
import static com.api.inventario.application.error.util.ErrorManager.*;
import static com.api.inventario.application.exception.util.ExceptionUtils.throwException;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final LoadPort<Area> areaLoadPort;
    private final UpdatePort<Area> areaUpdatePort;
    private final LoadPort<SystemState> systemStateLoadPort;
    private final UpdatePort<SystemState> systemStateUpdatePort;
    private final AreaMapper areaMapper;

    @Transactional
    @Override
    public AreaOutDto createArea(AreaInputDto dto) {
        if(verifyIfExist(dto.getAreaName()) !=null){
            throwException("Error creating area",HttpStatus.CONFLICT,ErrorCode.ERROR_CREATING);
        }
        Area area = areaMapper.areaFromAreaInputDto(dto);
        SystemState currentSystemState = systemStateLoadPort.getById(ACTIVE_ID);
        area.setAreaId(UUID.randomUUID());
        area.setAreaUsers(new ArrayList<>());
        area.setSystemState(currentSystemState);
        currentSystemState.getAreas().add(area);
        systemStateUpdatePort.save(currentSystemState);
        return areaMapper.areaOutDtoFromArea(areaUpdatePort.save(area));
    }



    @Override
    public AreaOutDto updateArea(AreaInputDto dto) {
        if(verifyIfExist(dto.getAreaName()) ==null){
           throwException("Error updating the area",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return areaMapper.areaOutDtoFromArea(areaUpdatePort.update(areaMapper.areaFromAreaInputDto(dto)));
    }

    @Override
    public AreaOutDto deleteArea(String areaId) {
        if(verifyIfExistById(areaId) ==null){
            throwException("Error deleting the area",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return areaMapper.areaOutDtoFromArea(areaUpdatePort.delete(areaLoadPort.getById(areaId)));
    }

    @Override
    public AreaOutDto getArea(String areaId) {
        if(verifyIfExistById(areaId) ==null){
            throwException("Error getting the area",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return areaMapper.areaOutDtoFromArea(areaLoadPort.getById(areaId));
    }

    @Override
    public List<AreaOutDto> getAllAreas() {
        return areaLoadPort.getAll().stream().map(areaMapper::areaOutDtoFromArea).collect(Collectors.toList());
    }

    private Area verifyIfExist(String areaName){
        return areaLoadPort.getByCriteria(AreaSpecification.getByAreaName(areaName));
    }

    private Area verifyIfExistById(String id){
        return areaLoadPort.getById(id);
    }


}
