package com.donaton.Donacion.factory;

import java.time.LocalDateTime;

import com.donaton.Donacion.model.Donacion;

public class DonacionFactory {

    public static Donacion crearDonacion(String tipo, String recurso, int cantidad, String origen, String centroAcopio) {
        Donacion nuevaDonacion = new Donacion();
        nuevaDonacion.setTipo(tipo);
        nuevaDonacion.setRecurso(recurso);
        nuevaDonacion.setCantidad(cantidad);
        nuevaDonacion.setOrigen(origen);
        nuevaDonacion.setCentroAcopioAsignado(centroAcopio);
        nuevaDonacion.setFechaIngreso(LocalDateTime.now());
        
        // Aquí se podrían agregar validaciones específicas según el 'tipo' (ej. caducidad si es Medicina)
        return nuevaDonacion;
    }
}