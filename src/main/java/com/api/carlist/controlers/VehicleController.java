package com.api.carlist.controlers;

import com.api.carlist.dtos.VehicleDto;
import com.api.carlist.models.VehicleTypeModel;
import com.api.carlist.models.VehicleModel;
import com.api.carlist.services.VehicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vehicle-list")
public class VehicleController {
    final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Object> saveVehicle(@RequestBody @Valid VehicleDto vehicleDto){

        VehicleModel vehicleModel = new VehicleModel();
        BeanUtils.copyProperties(vehicleDto, vehicleModel);
        VehicleTypeModel vehicleTypeModel = new VehicleTypeModel();
        vehicleTypeModel.setId(vehicleDto.getIdVehicleType());
        vehicleModel.setVehicleType(vehicleTypeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleModel));
    }

    @GetMapping
    public ResponseEntity<List<VehicleModel>> getAllVehicles(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVehicle(@PathVariable(value = "id") Long id) {
        Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
        if (!vehicleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicleModelOptional.get());
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteVehicle(@PathVariable(value = "id") Long id){
        Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
        if (!vehicleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found.");
        }
        vehicleService.delete(vehicleModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vehicle deleted successfully");
    }

    @PutMapping
    public ResponseEntity<Object> deleteVehicle(@PathVariable(value = "id") Long id,
                                                @RequestBody @Valid VehicleDto vehicleDto){
        Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
        if (!vehicleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found.");
        }
        var vehicleModel = new VehicleModel();
        BeanUtils.copyProperties(vehicleDto, vehicleModel);
        vehicleModel.setId((vehicleModelOptional.get().getId()));
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.save(vehicleModel));
    }


}
