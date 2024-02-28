package com.api.inventario.infrastructure.repository;

import com.api.inventario.domain.model.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserPrincipal, UUID> {
    Optional<UserPrincipal> findByUserName(String userName);

}
