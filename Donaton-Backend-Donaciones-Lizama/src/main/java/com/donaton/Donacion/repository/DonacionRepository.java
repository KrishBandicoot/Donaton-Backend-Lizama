package com.donaton.Donacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donaton.Donacion.model.Donacion;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long> {
    // Spring Data JPA provee los métodos save(), findAll(), findById() automáticamente.
}