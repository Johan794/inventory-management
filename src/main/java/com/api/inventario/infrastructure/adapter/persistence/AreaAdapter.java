package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Area;
import com.api.inventario.infrastructure.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class AreaAdapter implements LoadPort<Area>  , UpdatePort<Area> {
    private final AreaRepository areaRepository;
    @Override
    public Area getById(String id) {
        return null;
    }

    @Override
    public List<Area> getAll() {
        return null;
    }

    @Override
    public Area validateFolowwingSpec(Specification<?> Specification, Area Object) {
        return null;
    }

    @Override
    public Area save(Area object) {
        return null;
    }

    @Override
    public Area delete(Area object) {
        return null;
    }

    @Override
    public Area update(Area object) {
        return null;
    }
}
