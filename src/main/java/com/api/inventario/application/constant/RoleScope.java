package com.api.inventario.application.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleScope {
    ADMIN("MANAGE ALL SYSTEM"),
    SUPERVISOR("READ INFORMATION ABOUT INVENTORY");
    private  final String scope;
}
