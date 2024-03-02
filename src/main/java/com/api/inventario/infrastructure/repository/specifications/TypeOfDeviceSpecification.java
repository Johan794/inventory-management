package com.api.inventario.infrastructure.repository.specifications;

import com.api.inventario.domain.model.TypeOfDevice;
import org.springframework.data.jpa.domain.Specification;

public class TypeOfDeviceSpecification {
    public  static Specification<TypeOfDevice> getByTypeName(String typeName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("typeName"),typeName));
    }
}
