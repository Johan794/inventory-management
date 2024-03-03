package com.api.inventario.application.specifications;

import com.api.inventario.domain.model.DeviceModel;
import org.springframework.data.jpa.domain.Specification;

public class DeviceModelSpecification {

    public static Specification<DeviceModel> getByDeviceName(String name){
        return ((root, query, criteriaBuilder) ->criteriaBuilder.equal(root.get("modelName"),name));
    }
}
