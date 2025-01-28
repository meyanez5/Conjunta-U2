package com.example.Driver.Service;

import com.example.Driver.Entity.DriverEntity;
import com.example.Driver.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // Save a new driver
    public DriverEntity saveDriver(DriverEntity driverEntity) {
        return driverRepository.save(driverEntity);
    }

    // Get a driver by ID
    public Optional<DriverEntity> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    // Get all drivers
    public List<DriverEntity> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Update an existing driver by ID
    public DriverEntity updateDriver(Long id, DriverEntity updatedDriverEntity) {
        Optional<DriverEntity> existingDriver = driverRepository.findById(id);
        if (existingDriver.isPresent()) {
            DriverEntity driver = existingDriver.get();
            // Update fields
            driver.setNombre(updatedDriverEntity.getNombre());
            driver.setNumeroLicencia(updatedDriverEntity.getNumeroLicencia());
            driver.setTelefono(updatedDriverEntity.getTelefono());
            // Add any other fields that need to be updated
            return driverRepository.save(driver);
        } else {
            throw new RuntimeException("Driver not found with id: " + id);
        }
    }

    // Delete a driver by ID
    public void deleteDriver(Long id) {
        Optional<DriverEntity> existingDriver = driverRepository.findById(id);
        if (existingDriver.isPresent()) {
            driverRepository.delete(existingDriver.get());
        } else {
            throw new RuntimeException("Driver not found with id: " + id);
        }
    }
}