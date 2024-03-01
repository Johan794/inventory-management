package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Manufacturer;
import com.api.inventario.infrastructure.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ManufacturerAdapter implements LoadPort<Manufacturer> , UpdatePort<Manufacturer> {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer getById(String id) {
        return manufacturerRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getByCriteria(Specification<Manufacturer> specification) {
        return manufacturerRepository.findOne(specification).orElse(null);
    }

    @Override
    public Manufacturer save(Manufacturer object) {
        return manufacturerRepository.save(object);
    }

    @Override
    public Manufacturer delete(Manufacturer object) {
        manufacturerRepository.delete(object);
        return object;
    }

    @Override
    public Manufacturer update(Manufacturer object) {
        return manufacturerRepository.save(object);
    }
}
