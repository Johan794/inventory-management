package com.api.inventario.infrastructure.repository;

import com.api.inventario.domain.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepository  extends JpaRepository<Device, UUID> , JpaSpecificationExecutor<Device> {

}
