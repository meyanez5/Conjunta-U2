package com.example.Driver.Controller;

import com.example.Driver.Entity.DriverEntity;
import com.example.Driver.Service.DriverService;
import com.example.Driver.Utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/driver")
@CrossOrigin(origins = "http://localhost:5173")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // Create a new driver
    @PostMapping
    public ResponseEntity<?> createDriver(@Valid @RequestBody DriverEntity driverEntity, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = Validation.getValidationErrors(result);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        DriverEntity newDriver = driverService.saveDriver(driverEntity);
        return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
    }

    // Get a driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<DriverEntity> getDriver(@PathVariable Long id) {
        return driverService.getDriverById(id)
                .map(driverEntity -> new ResponseEntity<>(driverEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all drivers
    @GetMapping
    public ResponseEntity<List<DriverEntity>> getAllDrivers() {
        List<DriverEntity> drivers = driverService.getAllDrivers();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    // Update a driver by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable Long id, @Valid @RequestBody DriverEntity updatedDriverEntity, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = Validation.getValidationErrors(result);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        try {
            DriverEntity driver = driverService.updateDriver(id, updatedDriverEntity);
            return new ResponseEntity<>(driver, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a driver by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        try {
            driverService.deleteDriver(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}