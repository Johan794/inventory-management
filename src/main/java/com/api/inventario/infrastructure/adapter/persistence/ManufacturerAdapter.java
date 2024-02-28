package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Manufacturer;
import com.api.inventario.infrastructure.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class ManufacturerAdapter implements LoadPort<Manufacturer> , UpdatePort<Manufacturer> {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer getById(String id) {
        return null;
    }

    @Override
    public List<Manufacturer> getAll() {
        return null;
    }

    @Override
    public Manufacturer validateFolowwingSpec(Specification<?> Specification, Manufacturer Object) {
        return null;
    }

    @Override
    public Manufacturer save(Manufacturer object) {
        return null;
    }

    @Override
    public Manufacturer delete(Manufacturer object) {
        return null;
    }

    @Override
    public Manufacturer update(Manufacturer object) {
        return null;
    }
}
