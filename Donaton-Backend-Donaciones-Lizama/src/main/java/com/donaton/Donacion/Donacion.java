package com.donaton.donacion.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Crea tablas separadas unidas por ID
public abstract class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double monto;
    private String fecha;

    // Getters y Setters...
}