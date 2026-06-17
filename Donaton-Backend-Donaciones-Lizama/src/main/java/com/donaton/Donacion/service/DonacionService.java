package com.donaton.Donacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donaton.Donacion.dto.DonacionRequestDTO;
import com.donaton.Donacion.factory.DonacionFactory;
import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.repository.DonacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    public Donacion registrarDonacion(DonacionRequestDTO request) {
        Donacion donacion = DonacionFactory.crearDonacion(request);
        return donacionRepository.save(donacion);
    }

    public List<Donacion> obtenerTodas() {
        return donacionRepository.findAll();
    }

    public void eliminarDonacion(Long id) {
        donacionRepository.deleteById(id);
    }

    public Donacion actualizarCantidad(Long id, int nuevaCantidad) {
        Optional<Donacion> donacionOpt = donacionRepository.findById(id);
        if (donacionOpt.isPresent()) {
            Donacion d = donacionOpt.get();
            d.setCantidad(nuevaCantidad);
            return donacionRepository.save(d);
        }
        throw new RuntimeException("Donación no encontrada");
    }
}