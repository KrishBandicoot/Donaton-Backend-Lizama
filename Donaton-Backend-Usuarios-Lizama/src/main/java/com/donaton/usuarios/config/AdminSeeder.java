package com.donaton.usuarios.config;

import com.donaton.usuarios.model.Usuario;
import com.donaton.usuarios.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminSeeder(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Si no existe el admin, lo crea al levantar el proyecto
        if (!usuarioRepository.existsByUsername("admin@donaton.cl")) {
            Usuario admin = new Usuario();
            admin.setUsername("admin@donaton.cl");
            admin.setPassword(passwordEncoder.encode("Admin123!")); // Contraseña segura
            admin.setNombre("Administrador Central");
            admin.setRol("ROLE_ADMIN"); // Rol clave para el Dashboard
            usuarioRepository.save(admin);
            System.out.println("✅ Usuario Administrador creado por defecto (admin@donaton.cl / Admin123!)");
        }
    }
}