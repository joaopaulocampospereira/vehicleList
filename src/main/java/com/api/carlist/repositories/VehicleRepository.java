package com.api.carlist.repositories;

import com.api.carlist.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {

}
