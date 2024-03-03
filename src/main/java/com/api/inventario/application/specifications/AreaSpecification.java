package com.api.inventario.application.specifications;

import com.api.inventario.domain.model.Area;
import org.springframework.data.jpa.domain.Specification;

public class AreaSpecification {
    public static Specification<Area> getByAreaName(String areaName){
        return ((root, query, criteriaBuilder) ->  criteriaBuilder.equal(root.get("areaName"),areaName)
        );

    }
}
