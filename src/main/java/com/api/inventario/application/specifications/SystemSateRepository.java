package com.api.inventario.application.specifications;

import com.api.inventario.domain.constant.SystemSateEnum;
import com.api.inventario.domain.model.SystemState;
import org.springframework.data.jpa.domain.Specification;

public class SystemSateRepository {
    public Specification<SystemState> getByState(SystemSateEnum systemSateEnum){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("state"),systemSateEnum));
    }
}
