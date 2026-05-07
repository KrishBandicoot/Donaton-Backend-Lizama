package com.donaton.logistica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String centroAcopioOrigen;
    private String destino;
    private String patenteTransporte;
    private String estado; // Ej: PREPARACION, EN_TRANSITO, ENTREGADO
    private LocalDateTime fechaDespacho;

    public Envio() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCentroAcopioOrigen() { return centroAcopioOrigen; }
    public void setCentroAcopioOrigen(String centroAcopioOrigen) { this.centroAcopioOrigen = centroAcopioOrigen; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public String getPatenteTransporte() { return patenteTransporte; }
    public void setPatenteTransporte(String patenteTransporte) { this.patenteTransporte = patenteTransporte; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaDespacho() { return fechaDespacho; }
    public void setFechaDespacho(LocalDateTime fechaDespacho) { this.fechaDespacho = fechaDespacho; }
}