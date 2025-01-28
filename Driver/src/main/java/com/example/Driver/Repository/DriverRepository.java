package com.example.Driver.Repository;

import com.example.Driver.Entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
    Optional<DriverEntity> findByNumeroLicencia(String numeroLicencia);
}
