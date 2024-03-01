package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.DeviceState;
import com.api.inventario.infrastructure.repository.DeviceStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class DeviceSateAdapter implements LoadPort<DeviceState> , UpdatePort<DeviceState> {
    private final DeviceStateRepository deviceStateRepository;

    @Override
    public DeviceState getById(String id) {
        return null;
    }

    @Override
    public List<DeviceState> getAll() {
        return null;
    }

    @Override
    public DeviceState getByCriteria(Specification<DeviceState> specification) {
        return null;
    }


    @Override
    public DeviceState save(DeviceState object) {
        return null;
    }

    @Override
    public DeviceState delete(DeviceState object) {
        return null;
    }

    @Override
    public DeviceState update(DeviceState object) {
        return null;
    }
}
