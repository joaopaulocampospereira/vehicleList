package com.api.carlist.controlers;

import com.api.carlist.dtos.VehicleTypeDto;
import com.api.carlist.models.VehicleTypeModel;
import com.api.carlist.services.VehicleTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vehicle-list/type")
public class TypeController {
    final VehicleTypeService vehicleTypeService;

    public TypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @PostMapping
    public ResponseEntity<Object> saveType(@RequestBody @Valid VehicleTypeDto vehicleTypeDto){

        var typeModel = new VehicleTypeModel();
        BeanUtils.copyProperties(vehicleTypeDto, typeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleTypeService.save(typeModel));
    }

    @GetMapping
    public ResponseEntity<List<VehicleTypeModel>> getAllTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneType(@PathVariable(value = "id") Long id) {
        Optional<VehicleTypeModel> typeModelOptional = vehicleTypeService.findById(id);
        if (!typeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle type not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(typeModelOptional.get());
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteType(@PathVariable(value = "id") Long id){
        Optional<VehicleTypeModel> typeModelOptional = vehicleTypeService.findById(id);
        if (!typeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found.");
        }
        vehicleTypeService.delete(typeModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vehicle type deleted successfully");
    }

    @PutMapping
    public ResponseEntity<Object> deleteType(@PathVariable(value = "id") Long id,
                                                @RequestBody @Valid VehicleTypeDto vehicleTypeDto){
        Optional<VehicleTypeModel> typeModelOptional = vehicleTypeService.findById(id);
        if (!typeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle type not found.");
        }
        var typeModel = new VehicleTypeModel();
        BeanUtils.copyProperties(vehicleTypeDto, typeModel);
        typeModel.setId((typeModelOptional.get().getId()));
        return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.save(typeModel));
    }


}
