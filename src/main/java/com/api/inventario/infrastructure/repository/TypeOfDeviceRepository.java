package com.api.inventario.infrastructure.repository;

import com.api.inventario.domain.model.TypeOfDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TypeOfDeviceRepository extends JpaRepository<TypeOfDevice, UUID> , JpaSpecificationExecutor<TypeOfDevice> {
}
