package com.api.carlist.repositories;

import com.api.carlist.models.VehicleTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleTypeModel, Long> {

}
