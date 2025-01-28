package com.example.Vehicle.Repository;

import com.example.Vehicle.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDriverRepository extends JpaRepository<Vehicle, Long> {
    // Additional query methods can be defined here if needed
}