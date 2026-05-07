package com.donaton.Donacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donaton.Donacion.factory.DonacionFactory;
import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.repository.DonacionRepository;

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