package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.Device;
import com.api.inventario.infrastructure.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class DeviceApadter implements LoadPort<Device> , UpdatePort<Device> {
    private final DeviceRepository deviceRepository;

    @Override
    public Device getById(String id) {
        return null;
    }

    @Override
    public List<Device> getAll() {
        return null;
    }

    @Override
    public Device validateFolowwingSpec(Specification<?> Specification, Device Object) {
        return null;
    }

    @Override
    public Device save(Device object) {
        return null;
    }

    @Override
    public Device delete(Device object) {
        return null;
    }

    @Override
    public Device update(Device object) {
        return null;
    }
}
