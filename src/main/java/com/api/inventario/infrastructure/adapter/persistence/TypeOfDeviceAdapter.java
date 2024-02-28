package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.TypeOfDevice;
import com.api.inventario.infrastructure.repository.TypeOfDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class TypeOfDeviceAdapter implements LoadPort<TypeOfDevice> , UpdatePort<TypeOfDevice> {
    private final TypeOfDeviceRepository typeOfDeviceRepository;

    @Override
    public TypeOfDevice getById(String id) {
        return null;
    }

    @Override
    public List<TypeOfDevice> getAll() {
        return null;
    }

    @Override
    public TypeOfDevice validateFolowwingSpec(Specification<?> Specification, TypeOfDevice Object) {
        return null;
    }

    @Override
    public TypeOfDevice save(TypeOfDevice object) {
        return null;
    }

    @Override
    public TypeOfDevice delete(TypeOfDevice object) {
        return null;
    }

    @Override
    public TypeOfDevice update(TypeOfDevice object) {
        return null;
    }
}