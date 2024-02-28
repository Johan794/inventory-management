package com.api.inventario.application.port.output;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface LoadPort<T> {
    T getById(String id);

    List<T> getAll();

    T validateFolowwingSpec(Specification<?> Specification , T Object);
}
