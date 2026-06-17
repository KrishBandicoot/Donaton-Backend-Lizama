package com.donaton.Donacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.donaton.Donacion.dto.DonacionRequestDTO;
import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.service.DonacionService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donacion")
@CrossOrigin(origins = "*") 
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    @PostMapping
    public ResponseEntity<Donacion> crearDonacion(@RequestBody DonacionRequestDTO request) {
        Donacion nuevaDonacion = donacionService.registrarDonacion(request);
        return ResponseEntity.ok(nuevaDonacion);
    }

    @GetMapping
    public ResponseEntity<List<Donacion>> listarDonaciones() {
        return ResponseEntity.ok(donacionService.obtenerTodas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDonacion(@PathVariable Long id) {
        donacionService.eliminarDonacion(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDonacion(@PathVariable Long id, @RequestBody Map<String, Integer> payload) {
        Donacion d = donacionService.actualizarCantidad(id, payload.get("cantidad"));
        return ResponseEntity.ok(d);
    }
}