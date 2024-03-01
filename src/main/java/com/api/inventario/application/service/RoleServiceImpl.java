package com.api.inventario.application.service;

import com.api.inventario.application.constant.RoleScope;
import com.api.inventario.application.port.input.RoleService;
import com.api.inventario.infrastructure.dto.inputDto.RoleInputDto;
import com.api.inventario.infrastructure.dto.outputDto.RoleOutDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class RoleServiceImpl implements RoleService {
    @Override
    public RoleOutDto createRole(RoleInputDto roleInputDto) {
        RoleScope scope = RoleScope.valueOf(roleInputDto.getScope());
        return null;
    }

    @Override
    public RoleOutDto updateRole(RoleInputDto roleInputDto) {
        return null;
    }

    @Override
    public RoleOutDto deleteRole(String roleId) {
        return null;
    }

    @Override
    public RoleOutDto getRole(String roleId) {
        return null;
    }

    @Override
    public List<RoleOutDto> getAllRoles() {
        return null;
    }
}
