package com.donaton.proyecto.repository;

import com.donaton.proyecto.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long> {
    // Spring Data JPA provee los métodos save(), findAll(), findById() automáticamente.
}