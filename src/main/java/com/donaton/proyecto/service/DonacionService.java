package com.donaton.proyecto.service;

import com.donaton.proyecto.factory.DonacionFactory;
import com.donaton.proyecto.model.Donacion;
import com.donaton.proyecto.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    public Donacion registrarDonacion(String tipo, String recurso, int cantidad, String origen, String centroAcopio) {
        // Uso del Factory Method para crear la instancia
        Donacion donacion = DonacionFactory.crearDonacion(tipo, recurso, cantidad, origen, centroAcopio);
        
        // Uso del Repository Pattern para guardar en la BD
        return donacionRepository.save(donacion);
    }

    public List<Donacion> obtenerTodas() {
        return donacionRepository.findAll();
    }
}