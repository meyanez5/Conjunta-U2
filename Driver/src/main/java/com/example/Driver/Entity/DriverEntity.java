package com.example.Driver.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "driver")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Nombre no puede estar vacío")
    @Size(max = 50, message = "Nombre debe tener como máximo 50 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]+( [A-Za-zÑñÁáÉéÍíÓóÚú]+)*$",
            message = "Nombre solo debe contener letras"
    )
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "Apellido no puede estar vacío")
    @Size(max = 50, message = "Apellido debe tener como máximo 50 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]+( [A-Za-zÑñÁáÉéÍíÓóÚú]+)*$",
            message = "Apellido solo debe contener letras"
    )
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @NotBlank(message = "Número de licencia no puede estar vacío")
    @Size(max = 20, message = "Número de licencia debe tener como máximo 20 caracteres")
    @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "Número de licencia debe ser válido"
    )
    @Column(name = "numero_licencia", nullable = false, unique = true)
    private String numeroLicencia;

    @NotBlank(message = "Teléfono no puede estar vacío")
    @Pattern(
            regexp = "\\+?[0-9]+",
            message = "El teléfono debe ser válido y contener solo números (opcionalmente iniciar con +)"
    )
    @Size(min = 7, max = 15, message = "El teléfono debe tener entre 7 y 15 caracteres")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @NotBlank(message = "Email no puede estar vacío")
    @Email(message = "Email debe ser válido")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nombre no puede estar vacío") @Size(max = 50, message = "Nombre debe tener como máximo 50 caracteres") @Pattern(
            regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]+( [A-Za-zÑñÁáÉéÍíÓóÚú]+)*$",
            message = "Nombre solo debe contener letras"
    ) String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "Nombre no puede estar vacío") @Size(max = 50, message = "Nombre debe tener como máximo 50 caracteres") @Pattern(
            regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]+( [A-Za-zÑñÁáÉéÍíÓóÚú]+)*$",
            message = "Nombre solo debe contener letras"
    ) String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Apellido no puede estar vacío") @Size(max = 50, message = "Apellido debe tener como máximo 50 caracteres") @Pattern(
            regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]+( [A-Za-zÑñÁáÉéÍíÓóÚú]+)*$",
            message = "Apellido solo debe contener letras"
    ) String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "Apellido no puede estar vacío") @Size(max = 50, message = "Apellido debe tener como máximo 50 caracteres") @Pattern(
            regexp = "^[A-Za-zÑñÁáÉéÍíÓóÚú]+( [A-Za-zÑñÁáÉéÍíÓóÚú]+)*$",
            message = "Apellido solo debe contener letras"
    ) String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "Número de licencia no puede estar vacío") @Size(max = 20, message = "Número de licencia debe tener como máximo 20 caracteres") @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "Número de licencia debe ser válido"
    ) String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(@NotBlank(message = "Número de licencia no puede estar vacío") @Size(max = 20, message = "Número de licencia debe tener como máximo 20 caracteres") @Pattern(
            regexp = "^[A-Za-z0-9-]+$",
            message = "Número de licencia debe ser válido"
    ) String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public @NotBlank(message = "Teléfono no puede estar vacío") @Pattern(
            regexp = "\\+?[0-9]+",
            message = "El teléfono debe ser válido y contener solo números (opcionalmente iniciar con +)"
    ) @Size(min = 7, max = 15, message = "El teléfono debe tener entre 7 y 15 caracteres") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "Teléfono no puede estar vacío") @Pattern(
            regexp = "\\+?[0-9]+",
            message = "El teléfono debe ser válido y contener solo números (opcionalmente iniciar con +)"
    ) @Size(min = 7, max = 15, message = "El teléfono debe tener entre 7 y 15 caracteres") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "Email no puede estar vacío") @Email(message = "Email debe ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email no puede estar vacío") @Email(message = "Email debe ser válido") String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getters y setters

}