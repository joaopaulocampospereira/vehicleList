package com.api.carlist.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VehicleDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Long idVehicleType;
    @NotBlank
    private String plate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdVehicleType() {
        return idVehicleType;
    }

    public void setIdVehicleType(Long idVehicleType) {
        this.idVehicleType = idVehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
