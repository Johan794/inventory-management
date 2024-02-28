package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.DeviceModel;
import com.api.inventario.infrastructure.repository.DeviceModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class DeviceModelAdapter implements LoadPort<DeviceModel> , UpdatePort<DeviceModel> {
    private final DeviceModelRepository deviceModelRepository;


    @Override
    public DeviceModel getById(String id) {
        return null;
    }

    @Override
    public List<DeviceModel> getAll() {
        return null;
    }

    @Override
    public DeviceModel validateFolowwingSpec(Specification<?> Specification, DeviceModel Object) {
        return null;
    }

    @Override
    public DeviceModel save(DeviceModel object) {
        return null;
    }

    @Override
    public DeviceModel delete(DeviceModel object) {
        return null;
    }

    @Override
    public DeviceModel update(DeviceModel object) {
        return null;
    }
}
