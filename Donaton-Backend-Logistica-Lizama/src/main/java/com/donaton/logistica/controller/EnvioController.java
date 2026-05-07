package com.donaton.logistica.controller;

import com.donaton.logistica.model.Envio;
import com.donaton.logistica.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envio")
@CrossOrigin(origins = "*")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @PostMapping
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio request) {
        Envio nuevoEnvio = envioService.planificarEnvio(
                request.getCentroAcopioOrigen(),
                request.getDestino(),
                request.getPatenteTransporte()
        );
        return ResponseEntity.ok(nuevoEnvio);
    }

    @GetMapping
    public ResponseEntity<List<Envio>> listarEnvios() {
        return ResponseEntity.ok(envioService.obtenerTodos());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Envio> cambiarEstado(@PathVariable Long id, @RequestBody String nuevoEstado) {
        Envio envioActualizado = envioService.actualizarEstado(id, nuevoEstado);
        return ResponseEntity.ok(envioActualizado);
    }
}