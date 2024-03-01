package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.UserPrincipal;
import com.api.inventario.infrastructure.dto.inputDto.UserInputDto;
import com.api.inventario.infrastructure.dto.outputDto.UserOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DeviceMapper.class,StateMapper.class})
public interface UserMapper {

    @Mapping(source = "role",target = "role",ignore = true)
    UserPrincipal userPrincipalFromUserInputDto(UserInputDto userInputDto);
    UserOutDto userOutDtoFromUserPrincipal(UserPrincipal userPrincipal);
}
