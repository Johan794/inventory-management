package com.api.inventario.application.specifications;


import com.api.inventario.domain.model.DeviceState;
import org.springframework.data.jpa.domain.Specification;

public class DeviceSateSpecification {
    public static Specification<DeviceState> getByDescription(String description){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("stateDescription"),description));
    }
}
