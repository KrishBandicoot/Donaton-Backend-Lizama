package com.donaton.usuarios.controller;

import com.donaton.usuarios.dto.AuthResponse;
import com.donaton.usuarios.dto.LoginRequest;
import com.donaton.usuarios.dto.RegistroRequest;
import com.donaton.usuarios.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroRequest registroRequest) {
        try {
            String respuesta = usuarioService.registrar(registroRequest);
            // Retornamos un JSON válido si el registro es exitoso
            return ResponseEntity.ok(Map.of("mensaje", respuesta));
        } catch (RuntimeException e) {
            // Si el correo ya existe u ocurre un error de lógica, mandamos 400 Bad Request con el error exacto
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse respuesta = usuarioService.autenticar(loginRequest);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            // Si las credenciales están mal, devolvemos 401 Unauthorized
            return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
        }
    }
}