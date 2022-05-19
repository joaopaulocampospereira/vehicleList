package com.api.carlist.services;

import com.api.carlist.models.VehicleTypeModel;
import com.api.carlist.repositories.VehicleTypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    final
    VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Transactional
    public VehicleTypeModel save(VehicleTypeModel vehicleTypeModel) {
        return vehicleTypeRepository.save(vehicleTypeModel);
    }

    public List<VehicleTypeModel> findAll() {
        return vehicleTypeRepository.findAll();
    }

    public Optional<VehicleTypeModel> findById(Long id) {
        return vehicleTypeRepository.findById(id);
    }

    @Transactional
    public void delete(VehicleTypeModel vehicleTypeModel) {
        vehicleTypeRepository.delete(vehicleTypeModel);
    }
}
