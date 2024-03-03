package com.api.inventario.application.specifications;

import com.api.inventario.domain.model.Manufacturer;
import org.springframework.data.jpa.domain.Specification;

public class ManufacturerSpecification {

    public static Specification<Manufacturer> getByName(String manufacturerName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("manufacturerName"),manufacturerName));
    }
}
