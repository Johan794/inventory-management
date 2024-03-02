package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.DeviceState;
import com.api.inventario.infrastructure.repository.DeviceStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class DeviceSateAdapter implements LoadPort<DeviceState> , UpdatePort<DeviceState> {
    private final DeviceStateRepository deviceStateRepository;

    @Override
    public DeviceState getById(String id) {
        return deviceStateRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<DeviceState> getAll() {
        return deviceStateRepository.findAll();
    }

    @Override
    public DeviceState getByCriteria(Specification<DeviceState> specification) {
        return deviceStateRepository.findOne(specification).orElse(null);
    }


    @Override
    public DeviceState save(DeviceState object) {
        return deviceStateRepository.save(object);
    }

    @Override
    public DeviceState delete(DeviceState object) {
        deviceStateRepository.delete(object);
        return object;
    }

    @Override
    public DeviceState update(DeviceState object) {
        return deviceStateRepository.save(object);
    }
}
