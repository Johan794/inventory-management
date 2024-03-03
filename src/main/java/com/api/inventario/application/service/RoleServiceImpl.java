package com.api.inventario.application.service;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.constant.RoleScope;
import com.api.inventario.application.mapper.RoleMapper;
import com.api.inventario.application.port.input.RoleService;
import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.application.service.utils.ObjectValidator;
import com.api.inventario.domain.model.Role;
import com.api.inventario.application.dto.inputDto.RoleInputDto;
import com.api.inventario.application.dto.outputDto.RoleOutDto;
import com.api.inventario.application.specifications.RoleSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import static com.api.inventario.application.exception.util.ExceptionUtils.throwException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;
    private final LoadPort<Role> roleLoadPort;
    private final UpdatePort<Role> roleUpdatePort;
    private final ObjectValidator<Role> roleObjectValidator;
    @Override
    public RoleOutDto createRole(RoleInputDto roleInputDto) {
        if(roleObjectValidator.checkIfExistByName(RoleSpecification.getByRoleName(roleInputDto.getRoleName()),roleLoadPort)!=null){
            throwException("Error creating role", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }
        RoleScope scope = RoleScope.valueOf(roleInputDto.getScope());
        Role roleToSave = roleMapper.roleFromRoleInputDto(roleInputDto);
        roleToSave.setRoleId(UUID.randomUUID());
        roleToSave.setScope(scope);

        roleToSave.setUserPrincipalList(new ArrayList<>());
        return roleMapper.roleOutDtoFromRole(roleUpdatePort.save(roleToSave));
    }

    @Override
    public RoleOutDto updateRole(RoleInputDto roleInputDto) {
        if(roleObjectValidator.checkIfExistByName(RoleSpecification.getByRoleName(roleInputDto.getRoleName()),roleLoadPort)==null){
            throwException("Error creating role", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }
        return roleMapper.roleOutDtoFromRole(roleUpdatePort.update(roleMapper.roleFromRoleInputDto(roleInputDto)));
    }

    @Override
    public RoleOutDto deleteRole(String roleId) {
        if(roleObjectValidator.checkIfExistById(roleId,roleLoadPort)== null){
            throwException("Error deleting the role",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return roleMapper.roleOutDtoFromRole(roleUpdatePort.delete(roleLoadPort.getById(roleId)));
    }

    @Override
    public RoleOutDto getRole(String roleId) {
        if(roleObjectValidator.checkIfExistById(roleId,roleLoadPort)== null){
            throwException("Error getting the role",HttpStatus.NOT_FOUND,ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return roleMapper.roleOutDtoFromRole(roleLoadPort.getById(roleId));
    }

    @Override
    public List<RoleOutDto> getAllRoles() {
        return roleLoadPort.getAll().stream().map(roleMapper::roleOutDtoFromRole).collect(Collectors.toList());
    }
}
