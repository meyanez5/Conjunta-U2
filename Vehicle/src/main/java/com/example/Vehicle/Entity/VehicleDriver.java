package com.example.Vehicle.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_driver")
public class VehicleDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "vehicle_id", nullable = false)
    private long vehicleId; // FK to Vehicle

    @Column(name = "driver_id", nullable = false)
    private long driverId; // FK to Driver

    // Getters and setters...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
}
