package com.donaton.logistica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogos")
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipoCatalogo; // Guardará "TIPO_AYUDA", "CENTRO_ACOPIO" o "DESTINO"
    private String valor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipoCatalogo() { return tipoCatalogo; }
    public void setTipoCatalogo(String tipoCatalogo) { this.tipoCatalogo = tipoCatalogo; }
    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }
}