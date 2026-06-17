package com.donaton.usuarios.service;

import com.donaton.usuarios.dto.LoginRequest;
import com.donaton.usuarios.dto.RegistroRequest;
import com.donaton.usuarios.dto.AuthResponse;
import com.donaton.usuarios.model.Usuario;
import com.donaton.usuarios.repository.UsuarioRepository;
import com.donaton.usuarios.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public String registrar(RegistroRequest request) {
        if (usuarioRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya se encuentra registrado");
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(request.getUsername());
        nuevoUsuario.setPassword(passwordEncoder.encode(request.getPassword()));
        nuevoUsuario.setNombre(request.getNombre());
        nuevoUsuario.setRol("ROLE_USER"); 

        usuarioRepository.save(nuevoUsuario);
        return "Usuario registrado de manera exitosa";
    }

    public AuthResponse autenticar(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        String token = tokenProvider.generarToken(usuario.getUsername(), usuario.getRol());
        
        // Aquí pasamos el nombre real (o razón social) extraído de la base de datos
        return new AuthResponse(token, usuario.getUsername(), usuario.getRol(), usuario.getNombre());
    }
}