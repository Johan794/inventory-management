package com.api.inventario.application.service;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.mapper.UserMapper;
import com.api.inventario.application.port.input.UserService;
import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.application.service.utils.ObjectValidator;
import com.api.inventario.domain.model.Area;
import com.api.inventario.domain.model.Role;
import com.api.inventario.domain.model.SystemState;
import com.api.inventario.domain.model.UserPrincipal;
import com.api.inventario.application.dto.inputDto.UserInputDto;
import com.api.inventario.application.dto.outputDto.UserOutDto;
import com.api.inventario.application.specifications.AreaSpecification;
import com.api.inventario.application.specifications.RoleSpecification;
import com.api.inventario.application.specifications.UserSpecification;
import lombok.RequiredArgsConstructor;

import static com.api.inventario.application.constant.SateIds.ACTIVE_ID;
import static com.api.inventario.application.exception.util.ExceptionUtils.throwException;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final LoadPort<UserPrincipal> userPrincipalLoadPort;
    private final UpdatePort<UserPrincipal> userPrincipalUpdatePort;
    private final LoadPort<Role> roleLoadPort;
    private final UpdatePort<Role> roleUpdatePort;
    private final UserMapper userMapper;
    private final ObjectValidator<UserPrincipal> userPrincipalObjectValidator;
    private final PasswordEncoder encoder;
    private final LoadPort<Area> areaLoadPort;
    private final UpdatePort<Area> areaUpdatePort;
    private final LoadPort<SystemState> systemStateLoadPort;
    private final UpdatePort<SystemState> systemStateUpdatePort;





    @Override
    public UserOutDto createUser(UserInputDto userInputDto) {
        if(userPrincipalLoadPort.getByCriteria(UserSpecification.getByEmail(userInputDto.getEmail()))!=null){
            throwException("Error creating user, this email belongs to another user", HttpStatus.CONFLICT, ErrorCode.ERROR_CREATING);
        }

        Area areaForUser = findAreaByName(userInputDto.getAreaName()).orElseThrow(() -> {
            throwException("You can not create an user without an Area",HttpStatus.BAD_REQUEST,ErrorCode.ERROR_DEPENDENCIES);
            return null;
        });

        Role userRole = findByRoleName(userInputDto.getRole()).orElseThrow(()->{
            throwException("You can not create an user without a Role",HttpStatus.BAD_REQUEST,ErrorCode.ERROR_DEPENDENCIES);
            return null;
        });


        UserPrincipal userPrincipal = userMapper.userPrincipalFromUserInputDto(userInputDto);
        userPrincipal.setUserId(UUID.randomUUID());
        userPrincipal.setPassword(encoder.encode(userPrincipal.getPassword()));
        userPrincipal.setDevices(new ArrayList<>());

        userPrincipal.setArea(areaForUser);
        userPrincipal.setRole(userRole);
        userPrincipal.setSystemState(systemStateLoadPort.getById(ACTIVE_ID));

        userPrincipalUpdatePort.save(userPrincipal);
        buildRelations(areaForUser,userRole,userPrincipal.getSystemState(),userPrincipal);

        return userMapper.userOutDtoFromUserPrincipal(userPrincipal);
    }

    @Override
    public UserOutDto deleteUser(String userId) {
        if(userPrincipalObjectValidator.checkIfExistById(userId,userPrincipalLoadPort)==null){
            throwException("Error deleting the user", HttpStatus.NOT_FOUND, ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return userMapper.userOutDtoFromUserPrincipal(userPrincipalUpdatePort.delete(userPrincipalLoadPort.getById(userId)));
    }

    @Override
    public UserOutDto updateUser(String userId) {
        if(userPrincipalObjectValidator.checkIfExistById(userId,userPrincipalLoadPort)==null){
            throwException("Error updating the user", HttpStatus.NOT_FOUND, ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return userMapper.userOutDtoFromUserPrincipal(userPrincipalUpdatePort.update(userPrincipalLoadPort.getById(userId)));
    }

    @Override
    public UserOutDto getUser(String userId) {
        if(userPrincipalObjectValidator.checkIfExistById(userId,userPrincipalLoadPort)==null){
            throwException("Error getting the user", HttpStatus.NOT_FOUND, ErrorCode.ERROR_RESOURCE_NOT_FOUND);
        }
        return userMapper.userOutDtoFromUserPrincipal(userPrincipalLoadPort.getById(userId));
    }

    @Override
    public List<UserOutDto> getAllUsers() {
        return userPrincipalLoadPort.getAll().stream().map(userMapper::userOutDtoFromUserPrincipal).collect(Collectors.toList());
    }

    private Optional<Area> findAreaByName(String areaName){
        return Optional.ofNullable(areaLoadPort.getByCriteria(AreaSpecification.getByAreaName(areaName)));
    }

    private Optional<Role> findByRoleName(String roleName){
        return Optional.ofNullable(roleLoadPort.getByCriteria(RoleSpecification.getByRoleName(roleName)));
    }

    private void buildRelations( Area areaForUser, Role userRole , SystemState state , UserPrincipal userPrincipal){
        areaForUser.getAreaUsers().add(userPrincipal);
        userRole.getUserPrincipalList().add(userPrincipal);
        state.getUserPrincipalList().add(userPrincipal);

        areaUpdatePort.save(areaForUser);
        roleUpdatePort.save(userRole);
        systemStateUpdatePort.save(state);
    }
}
