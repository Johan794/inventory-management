package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Area;
import com.api.inventario.infrastructure.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AreaAdapter implements LoadPort<Area>  , UpdatePort<Area> {
    private final AreaRepository areaRepository;
    @Override
    public Area getById(String id) {
        return areaRepository.findById(UUID.fromString(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area getByCriteria(Specification<Area> specification) {
        return areaRepository.findOne(specification).orElse(null);
    }


    @Override
    public Area save(Area object) {
        return areaRepository.save(object);
    }

    @Override
    public Area delete(Area object) {
        areaRepository.delete(object);
        return object;
    }

    @Override
    public Area update(Area object) {
        return areaRepository.save(object);
    }
}
