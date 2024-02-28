package com.api.inventario.infrastructure.adapter.external;

import com.api.inventario.infrastructure.dto.auth.JwtDto;
import com.api.inventario.infrastructure.dto.inputDto.LoginDto;

public interface ExternalService {

    JwtDto loginExternalService(LoginDto loginDto);




}
