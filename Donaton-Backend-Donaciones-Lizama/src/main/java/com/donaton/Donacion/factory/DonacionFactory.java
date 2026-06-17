package com.donaton.Donacion.factory;

import com.donaton.Donacion.dto.DonacionRequestDTO;
import com.donaton.Donacion.model.Donacion;
import java.time.LocalDateTime;

public class DonacionFactory {

    public static Donacion crearDonacion(DonacionRequestDTO dto) {
        Donacion donacion = new Donacion();
        
        donacion.setTipo(dto.getTipo());
        donacion.setRecurso(dto.getRecurso());
        donacion.setCantidad(dto.getCantidad());
        donacion.setOrigen(dto.getOrigen()); // Este ahora es el correo
        donacion.setCentroAcopioAsignado(dto.getCentroAcopioAsignado());
        
        // AQUÍ: Mapeamos el tipo de donante (Persona o Empresa)
        donacion.setTipoDonante(dto.getTipoDonante()); 
        
        donacion.setFechaIngreso(LocalDateTime.now());
        
        return donacion;
    }
}