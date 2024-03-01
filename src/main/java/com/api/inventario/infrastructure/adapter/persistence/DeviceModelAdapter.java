package com.api.inventario.infrastructure.adapter.persistence;

import com.api.inventario.application.port.output.LoadPort;
import com.api.inventario.application.port.output.UpdatePort;
import com.api.inventario.domain.model.DeviceModel;
import com.api.inventario.infrastructure.repository.DeviceModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class DeviceModelAdapter implements LoadPort<DeviceModel> , UpdatePort<DeviceModel> {
    private final DeviceModelRepository deviceModelRepository;


    @Override
    public DeviceModel getById(String id) {
        return deviceModelRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<DeviceModel> getAll() {
        return deviceModelRepository.findAll();
    }

    @Override
    public DeviceModel getByCriteria(Specification<DeviceModel> specification) {
        return deviceModelRepository.findOne(specification).orElse(null);
    }


    @Override
    public DeviceModel save(DeviceModel object) {
        return deviceModelRepository.save(object);
    }

    @Override
    public DeviceModel delete(DeviceModel object) {
        deviceModelRepository.delete(object);
        return object ;
    }

    @Override
    public DeviceModel update(DeviceModel object) {
        return deviceModelRepository.save(object);
    }
}
