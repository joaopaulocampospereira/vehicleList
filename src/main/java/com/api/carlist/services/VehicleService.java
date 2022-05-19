package com.api.carlist.services;

import com.api.carlist.models.VehicleModel;
import com.api.carlist.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {
    final
    VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleModel save(VehicleModel vehicleModel) {
        return vehicleRepository.save(vehicleModel);
    }

    public List<VehicleModel> findAll() {
        return vehicleRepository.findAll();
    }

    public Optional<VehicleModel> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Transactional
    public void delete(VehicleModel vehicleModel) {
        vehicleRepository.delete(vehicleModel);
    }
}
