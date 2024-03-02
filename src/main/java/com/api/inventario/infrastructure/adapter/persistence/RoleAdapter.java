package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Role;
import com.api.inventario.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class RoleAdapter implements LoadPort<Role>  , UpdatePort<Role> {
    private final RoleRepository roleRepository;

    @Override
    public Role getById(String id) {
        return roleRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getByCriteria(Specification<Role> specification) {
        return roleRepository.findOne(specification).orElse(null);
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public Role delete(Role object) {
        roleRepository.save(object);
        return object;
    }

    @Override
    public Role update(Role object) {
        return roleRepository.save(object);
    }
}
