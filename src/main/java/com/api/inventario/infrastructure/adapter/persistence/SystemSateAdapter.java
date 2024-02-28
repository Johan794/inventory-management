package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.SystemState;
import com.api.inventario.infrastructure.repository.SystemStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class SystemSateAdapter implements LoadPort<SystemState> , UpdatePort<SystemState> {
    private final SystemStateRepository systemStateRepository;

    @Override
    public SystemState getById(String id) {
        return null;
    }

    @Override
    public List<SystemState> getAll() {
        return null;
    }

    @Override
    public SystemState validateFolowwingSpec(Specification<?> Specification, SystemState Object) {
        return null;
    }

    @Override
    public SystemState save(SystemState object) {
        return null;
    }

    @Override
    public SystemState delete(SystemState object) {
        return null;
    }

    @Override
    public SystemState update(SystemState object) {
        return null;
    }
}
