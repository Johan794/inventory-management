package com.api.inventario.infrastructure.repository.specifications;

import com.api.inventario.domain.model.UserPrincipal;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

   public static Specification<UserPrincipal> geyByUserName(String userName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userName"),userName));
    }

   public static Specification<UserPrincipal> geyByname(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),name));
    }
}
