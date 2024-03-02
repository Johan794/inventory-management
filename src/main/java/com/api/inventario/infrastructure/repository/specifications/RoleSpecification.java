package com.api.inventario.infrastructure.repository.specifications;

import com.api.inventario.domain.model.Role;
import org.springframework.data.jpa.domain.Specification;

public class RoleSpecification {
    public static Specification<Role> getByRoleName(String roleName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("roleName"),roleName));
    }
}
