package com.donaton.logistica.service;

import com.donaton.logistica.model.Envio;
import com.donaton.logistica.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public Envio planificarEnvio(String centroAcopio, String destino, String patente) {
        Envio nuevoEnvio = new Envio();
        nuevoEnvio.setCentroAcopioOrigen(centroAcopio);
        nuevoEnvio.setDestino(destino);
        nuevoEnvio.setPatenteTransporte(patente);
        nuevoEnvio.setEstado("PREPARACION");
        nuevoEnvio.setFechaDespacho(LocalDateTime.now());
        
        return envioRepository.save(nuevoEnvio);
    }

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public Envio actualizarEstado(Long id, String nuevoEstado) {
        Optional<Envio> envioOpt = envioRepository.findById(id);
        if (envioOpt.isPresent()) {
            Envio envio = envioOpt.get();
            envio.setEstado(nuevoEstado);
            return envioRepository.save(envio);
        }
        throw new RuntimeException("Envío no encontrado con ID: " + id);
    }
}