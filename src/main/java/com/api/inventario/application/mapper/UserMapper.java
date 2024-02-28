package com.api.inventario.application.mapper;

import com.api.inventario.domain.model.UserPrincipal;
import com.api.inventario.infrastructure.dto.inputDto.UserInputDto;
import com.api.inventario.infrastructure.dto.outputDto.UserOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserPrincipal userPrincipalFromUserInputDto(UserInputDto userInputDto);
    UserOutDto userOutDtoFromUserPrincipal(UserPrincipal userPrincipal);
}
