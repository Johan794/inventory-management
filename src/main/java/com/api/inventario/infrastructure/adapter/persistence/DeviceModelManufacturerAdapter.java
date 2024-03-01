package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.DeviceModelManufacturer;
import com.api.inventario.infrastructure.repository.DeviceModelManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class DeviceModelManufacturerAdapter implements LoadPort<DeviceModelManufacturer> , UpdatePort<DeviceModelManufacturer> {
    private final DeviceModelManufacturerRepository deviceModelManufacturerRepository;

    @Deprecated
    @Override
    public DeviceModelManufacturer getById(String id) {
        return null;
    }

    @Override
    public List<DeviceModelManufacturer> getAll() {
        return deviceModelManufacturerRepository.findAll();
    }

    @Override
    public DeviceModelManufacturer getByCriteria(Specification<DeviceModelManufacturer> specification) {
        return deviceModelManufacturerRepository.findOne(specification).orElse(null);
    }

    @Override
    public DeviceModelManufacturer save(DeviceModelManufacturer object) {
        return deviceModelManufacturerRepository.save(object);
    }

    @Override
    public DeviceModelManufacturer delete(DeviceModelManufacturer object) {
        deviceModelManufacturerRepository.delete(object);
        return object;
    }

    @Override
    public DeviceModelManufacturer update(DeviceModelManufacturer object) {
        return deviceModelManufacturerRepository.save(object);
    }
}
