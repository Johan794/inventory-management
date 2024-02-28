package com.api.inventario.infrastructure.repository;

import com.api.inventario.domain.model.SystemState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SystemStateRepository  extends JpaRepository<SystemState, UUID> {

}
