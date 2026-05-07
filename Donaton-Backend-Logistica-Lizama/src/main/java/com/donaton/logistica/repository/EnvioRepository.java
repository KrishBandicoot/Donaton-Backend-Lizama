package com.donaton.logistica.repository;

import com.donaton.logistica.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    // Podemos agregar métodos personalizados fácilmente gracias a Spring Data JPA
    List<Envio> findByEstado(String estado);
}