package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.UserPrincipal;
import com.api.inventario.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter  implements LoadPort<UserPrincipal> , UpdatePort<UserPrincipal> {
    private final UserRepository userRepository;

    @Override
    public UserPrincipal getById(String id) {
        return null;
    }

    @Override
    public List<UserPrincipal> getAll() {
        return null;
    }

    @Override
    public UserPrincipal getByCriteria(Specification<UserPrincipal> specification) {
        return null;
    }

    @Override
    public UserPrincipal save(UserPrincipal object) {
        return null;
    }

    @Override
    public UserPrincipal delete(UserPrincipal object) {
        return null;
    }

    @Override
    public UserPrincipal update(UserPrincipal object) {
        return null;
    }
}
