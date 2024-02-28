package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Role;
import com.api.inventario.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class RoleAdapter implements LoadPort<Role>  , UpdatePort<Role> {
    private final RoleRepository roleRepository;

    @Override
    public Role getById(String id) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role validateFolowwingSpec(Specification<?> Specification, Role Object) {
        return null;
    }

    @Override
    public Role save(Role object) {
        return null;
    }

    @Override
    public Role delete(Role object) {
        return null;
    }

    @Override
    public Role update(Role object) {
        return null;
    }
}
