package com.donaton.proyecto.controller;

import com.donaton.proyecto.model.Donacion;
import com.donaton.proyecto.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donacion")
@CrossOrigin(origins = "*") // Permite la conexión con el Frontend
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    @PostMapping
    public ResponseEntity<Donacion> crearDonacion(@RequestBody Donacion request) {
        Donacion nuevaDonacion = donacionService.registrarDonacion(
                request.getTipo(),
                request.getRecurso(),
                request.getCantidad(),
                request.getOrigen(),
                request.getCentroAcopioAsignado()
        );
        return ResponseEntity.ok(nuevaDonacion);
    }

    @GetMapping
    public ResponseEntity<List<Donacion>> listarDonaciones() {
        return ResponseEntity.ok(donacionService.obtenerTodas());
    }
}