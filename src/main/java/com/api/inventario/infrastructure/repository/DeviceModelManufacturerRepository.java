package com.api.inventario.infrastructure.repository;

import com.api.inventario.domain.model.DeviceModelManufacturer;
import com.api.inventario.domain.model.DeviceModelManufacturerPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceModelManufacturerRepository extends JpaRepository<DeviceModelManufacturer, DeviceModelManufacturerPK> {

}
