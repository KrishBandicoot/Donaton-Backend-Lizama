package com.donaton.Donacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donaton.Donacion.dto.DonacionRequestDTO;
import com.donaton.Donacion.factory.DonacionFactory;
import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.repository.DonacionRepository;

import java.util.List;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    public Donacion registrarDonacion(DonacionRequestDTO request) {
        // Delegamos la creación al Factory Pattern
        Donacion donacion = DonacionFactory.crearDonacion(request);
        
        // Uso del Repository Pattern para guardar en la BD
        return donacionRepository.save(donacion);
    }

    public List<Donacion> obtenerTodas() {
        return donacionRepository.findAll();
    }
}