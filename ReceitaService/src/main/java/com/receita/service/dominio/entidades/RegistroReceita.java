package com.receita.service.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class RegistroReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private double valorCobrado;
    private double valorImpostos;

    public RegistroReceita(LocalDate data, double valorCobrado, double valorImpostos) {
        this.data = data;
        this.valorCobrado = valorCobrado;
        this.valorImpostos = valorImpostos;
    }

    protected RegistroReceita() {}

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public double getValorImpostos() {
        return valorImpostos;
    }
}
