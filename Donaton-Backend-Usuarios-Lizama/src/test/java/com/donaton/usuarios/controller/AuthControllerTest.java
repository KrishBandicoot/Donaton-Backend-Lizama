package com.donaton.usuarios.controller;

import com.donaton.usuarios.dto.AuthResponse;
import com.donaton.usuarios.dto.LoginRequest;
import com.donaton.usuarios.dto.RegistroRequest;
import com.donaton.usuarios.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private AuthController authController;

    @Test
    void autenticarUsuario_CredencialesValidas_Retorna200() {
        LoginRequest req = new LoginRequest();
        req.setUsername("admin@donaton.cl");
        req.setPassword("12345");

        AuthResponse mockResponse = new AuthResponse("jwt-token", "admin@donaton.cl", "ROLE_ADMIN", "Admin", "PERSONA");
        when(usuarioService.autenticar(any(LoginRequest.class))).thenReturn(mockResponse);

        ResponseEntity<?> response = authController.autenticarUsuario(req);

        // CORRECCIÓN AQUÍ: getStatusCode().value()
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
    }

    @Test
    void registrarUsuario_CorreoDuplicado_Retorna400() {
        RegistroRequest req = new RegistroRequest();
        when(usuarioService.registrar(any(RegistroRequest.class)))
                .thenThrow(new RuntimeException("El nombre de usuario ya se encuentra registrado"));

        ResponseEntity<?> response = authController.registrarUsuario(req);

        // CORRECCIÓN AQUÍ: getStatusCode().value()
        assertEquals(400, response.getStatusCode().value());
        assertTrue(((Map<?, ?>) response.getBody()).containsKey("error"));
    }
}