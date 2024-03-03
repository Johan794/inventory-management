package com.api.inventario.application.specifications;

import com.api.inventario.domain.model.DeviceModelManufacturer;
import com.api.inventario.domain.model.DeviceModelManufacturerPK;
import org.springframework.data.jpa.domain.Specification;

public class DeviceModelManufacturerSpecification {
    public static Specification<DeviceModelManufacturer> getById(DeviceModelManufacturerPK id){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"),id));
    }
}
