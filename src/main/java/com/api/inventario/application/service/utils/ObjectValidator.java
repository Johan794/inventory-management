package com.api.inventario.application.service.utils;

import com.api.inventario.application.port.output.LoadPort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ObjectValidator<T> {
    public T checkIfExistById(String id, LoadPort<T> loadPort){
        return loadPort.getById(id);

    }

    public T checkIfExistByName(Specification<T> nameSpec,LoadPort<T> loadPort){
        return loadPort.getByCriteria(nameSpec);
    }

}
