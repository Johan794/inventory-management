package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.UserPrincipal;
import com.api.inventario.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserAdapter  implements LoadPort<UserPrincipal> , UpdatePort<UserPrincipal> {
    private final UserRepository userRepository;

    @Override
    public UserPrincipal getById(String id) {
        return userRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<UserPrincipal> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserPrincipal getByCriteria(Specification<UserPrincipal> specification) {
        return userRepository.findOne(specification).orElse(null);
    }

    @Override
    public UserPrincipal save(UserPrincipal object) {
        return userRepository.save(object);
    }

    @Override
    public UserPrincipal delete(UserPrincipal object) {
        userRepository.delete(object);
        return object;
    }

    @Override
    public UserPrincipal update(UserPrincipal object) {
        return userRepository.save(object);
    }

    public Optional<UserPrincipal> getByUserName(String name){
        return userRepository.findByUserName(name);
    }
}
