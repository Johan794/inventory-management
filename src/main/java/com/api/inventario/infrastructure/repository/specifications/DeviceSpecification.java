package com.api.inventario.infrastructure.repository.specifications;

import com.api.inventario.domain.model.Device;
import org.springframework.data.jpa.domain.Specification;

public class DeviceSpecification {
    public static Specification<Device> getByDeviceName(String deviceName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),deviceName));
    }
}
