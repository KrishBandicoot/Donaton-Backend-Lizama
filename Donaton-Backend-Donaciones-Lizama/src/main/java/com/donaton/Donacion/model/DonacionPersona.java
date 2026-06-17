package com.donaton.Donacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "donaciones_personas")
public class DonacionPersona extends Donacion {
    private String rutPersona;
    private String nombreCompleto;

    public String getRutPersona() { return rutPersona; }
    public void setRutPersona(String rutPersona) { this.rutPersona = rutPersona; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
}