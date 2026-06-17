package com.donaton.usuarios.controller;

import com.donaton.usuarios.dto.AuthResponse;
import com.donaton.usuarios.dto.LoginRequest;
import com.donaton.usuarios.dto.RegistroRequest;
import com.donaton.usuarios.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Permite la comunicación transparente desde el Frontend/BFF
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registrarUsuario(@RequestBody RegistroRequest registroRequest) {
        String respuesta = usuarioService.registrar(registroRequest);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> autenticarUsuario(@RequestBody LoginRequest loginRequest) {
        AuthResponse respuesta = usuarioService.autenticar(loginRequest);
        return ResponseEntity.ok(respuesta);
    }
}