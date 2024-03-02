package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.TypeOfDevice;
import com.api.inventario.infrastructure.repository.TypeOfDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TypeOfDeviceAdapter implements LoadPort<TypeOfDevice> , UpdatePort<TypeOfDevice> {
    private final TypeOfDeviceRepository typeOfDeviceRepository;

    @Override
    public TypeOfDevice getById(String id) {
        return typeOfDeviceRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<TypeOfDevice> getAll() {
        return typeOfDeviceRepository.findAll();
    }

    @Override
    public TypeOfDevice getByCriteria(Specification<TypeOfDevice> specification) {
        return typeOfDeviceRepository.findOne(specification).orElse(null);
    }


    @Override
    public TypeOfDevice save(TypeOfDevice object) {
        return typeOfDeviceRepository.save(object);
    }

    @Override
    public TypeOfDevice delete(TypeOfDevice object) {
        typeOfDeviceRepository.delete(object);
        return object;
    }

    @Override
    public TypeOfDevice update(TypeOfDevice object) {
        return typeOfDeviceRepository.save(object);
    }
}
