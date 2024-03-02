package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Device;
import com.api.inventario.infrastructure.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeviceApadter implements LoadPort<Device> , UpdatePort<Device> {
    private final DeviceRepository deviceRepository;

    @Override
    public Device getById(String id) {
        return deviceRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getByCriteria(Specification<Device> specification) {
        return deviceRepository.findOne(specification).orElse(null);
    }


    @Override
    public Device save(Device object) {
        return deviceRepository.save(object);
    }

    @Override
    public Device delete(Device object) {
        deviceRepository.delete(object);
        return object;
    }

    @Override
    public Device update(Device object) {
        return deviceRepository.save(object);
    }
}
