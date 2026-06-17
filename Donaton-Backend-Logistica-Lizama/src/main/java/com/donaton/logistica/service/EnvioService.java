package com.donaton.logistica.service;

import com.donaton.logistica.model.Envio;
import com.donaton.logistica.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public Envio registrarEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public void eliminarEnvio(Long id) {
        envioRepository.deleteById(id);
    }

    public Envio actualizarPatente(Long id, String nuevaPatente) {
        Optional<Envio> envioOpt = envioRepository.findById(id);
        if (envioOpt.isPresent()) {
            Envio e = envioOpt.get();
            e.setPatenteTransporte(nuevaPatente);
            return envioRepository.save(e);
        }
        throw new RuntimeException("Envío no encontrado");
    }
}