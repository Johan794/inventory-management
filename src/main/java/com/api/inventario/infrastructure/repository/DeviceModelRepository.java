package com.api.inventario.infrastructure.repository;

import com.api.inventario.domain.model.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface DeviceModelRepository extends JpaRepository<DeviceModel, UUID> , JpaSpecificationExecutor<DeviceModel> {

}
