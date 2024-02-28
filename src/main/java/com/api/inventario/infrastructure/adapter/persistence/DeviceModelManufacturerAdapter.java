package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.DeviceModelManufacturer;
import com.api.inventario.infrastructure.repository.DeviceModelManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class DeviceModelManufacturerAdapter implements LoadPort<DeviceModelManufacturer> , UpdatePort<DeviceModelManufacturer> {
    private final DeviceModelManufacturerRepository deviceModelManufacturerRepository;

    @Override
    public DeviceModelManufacturer getById(String id) {
        return null;
    }

    @Override
    public List<DeviceModelManufacturer> getAll() {
        return null;
    }

    @Override
    public DeviceModelManufacturer validateFolowwingSpec(Specification<?> Specification, DeviceModelManufacturer Object) {
        return null;
    }

    @Override
    public DeviceModelManufacturer save(DeviceModelManufacturer object) {
        return null;
    }

    @Override
    public DeviceModelManufacturer delete(DeviceModelManufacturer object) {
        return null;
    }

    @Override
    public DeviceModelManufacturer update(DeviceModelManufacturer object) {
        return null;
    }
}
