package com.api.inventario.infrastructure.repository;

import com.api.inventario.domain.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AreaRepository extends JpaRepository<Area, UUID> {
}
