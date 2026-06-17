package com.donaton.usuarios.dto;

public class AuthResponse {
    private String token;
    private String username;
    private String rol;
    private String nombre; 
    private String tipoUsuario; 

    public AuthResponse(String token, String username, String rol, String nombre, String tipoUsuario) {
        this.token = token;
        this.username = username;
        this.rol = rol;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}