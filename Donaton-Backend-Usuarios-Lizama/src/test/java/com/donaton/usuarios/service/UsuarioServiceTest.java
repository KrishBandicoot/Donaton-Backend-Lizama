package com.donaton.usuarios.service;

import com.donaton.usuarios.dto.RegistroRequest;
import com.donaton.usuarios.model.Usuario;
import com.donaton.usuarios.repository.UsuarioRepository;
import com.donaton.usuarios.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider tokenProvider;

    @InjectMocks
    private UsuarioService usuarioService;

    private RegistroRequest request;

    @BeforeEach
    void setUp() {
        request = new RegistroRequest();
        request.setUsername("test@correo.cl");
        request.setPassword("Password123!");
        request.setNombre("Juan Perez");
        request.setTipoUsuario("PERSONA");
    }

    @Test
    void registrar_UsuarioNuevo_Exito() {
        when(usuarioRepository.existsByUsername("test@correo.cl")).thenReturn(false);
        when(passwordEncoder.encode("Password123!")).thenReturn("hashedPassword");

        String respuesta = usuarioService.registrar(request);

        assertEquals("Usuario registrado de manera exitosa", respuesta);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void registrar_UsuarioExistente_LanzaExcepcion() {
        when(usuarioRepository.existsByUsername("test@correo.cl")).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            usuarioService.registrar(request);
        });

        assertEquals("El nombre de usuario ya se encuentra registrado", exception.getMessage());
        verify(usuarioRepository, never()).save(any(Usuario.class));
    }
}