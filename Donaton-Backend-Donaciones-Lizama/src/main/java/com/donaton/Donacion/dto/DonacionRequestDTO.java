package com.donaton.Donacion.dto;

public class DonacionRequestDTO {
    private String tipoDonante; // "EMPRESA" o "PERSONA"
    private String tipo;
    private String recurso;
    private int cantidad;
    private String origen;
    private String centroAcopioAsignado;
    
    // Datos específicos
    private String rut;
    private String nombreRazonSocial;

    // Getters y Setters
    public String getTipoDonante() { return tipoDonante; }
    public void setTipoDonante(String tipoDonante) { this.tipoDonante = tipoDonante; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getRecurso() { return recurso; }
    public void setRecurso(String recurso) { this.recurso = recurso; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public String getCentroAcopioAsignado() { return centroAcopioAsignado; }
    public void setCentroAcopioAsignado(String centroAcopioAsignado) { this.centroAcopioAsignado = centroAcopioAsignado; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombreRazonSocial() { return nombreRazonSocial; }
    public void setNombreRazonSocial(String nombreRazonSocial) { this.nombreRazonSocial = nombreRazonSocial; }
}