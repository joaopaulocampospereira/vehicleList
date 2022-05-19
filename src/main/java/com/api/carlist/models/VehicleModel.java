package com.api.carlist.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "TB_VEHICLE")
public class VehicleModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_vehicle_type")
    private VehicleTypeModel vehicleType;
    @Column(name="plate")
    private String plate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public VehicleTypeModel getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypeModel vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
