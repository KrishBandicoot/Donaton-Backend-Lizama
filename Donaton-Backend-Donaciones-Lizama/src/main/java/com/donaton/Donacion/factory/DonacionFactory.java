package com.donaton.Donacion.factory;

import com.donaton.Donacion.dto.DonacionRequestDTO;
import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.model.DonacionEmpresa;
import com.donaton.Donacion.model.DonacionPersona;

import java.time.LocalDateTime;

public class DonacionFactory {

    public static Donacion crearDonacion(DonacionRequestDTO request) {
        Donacion donacion;

        // El Factory decide qué instancia concreta crear (Empresa o Persona)
        if ("EMPRESA".equalsIgnoreCase(request.getTipoDonante())) {
            DonacionEmpresa empresa = new DonacionEmpresa();
            empresa.setRutEmpresa(request.getRut());
            empresa.setRazonSocial(request.getNombreRazonSocial());
            donacion = empresa; // Polimorfismo
        } else {
            DonacionPersona persona = new DonacionPersona();
            persona.setRutPersona(request.getRut());
            persona.setNombreCompleto(request.getNombreRazonSocial());
            donacion = persona; // Polimorfismo
        }

        // Se asignan los atributos compartidos definidos en la clase abstracta padre
        donacion.setTipo(request.getTipo());
        donacion.setRecurso(request.getRecurso());
        donacion.setCantidad(request.getCantidad());
        donacion.setOrigen(request.getOrigen());
        donacion.setCentroAcopioAsignado(request.getCentroAcopioAsignado());
        donacion.setFechaIngreso(LocalDateTime.now());

        return donacion;
    }
}