package com.imposto.service.dominio.entidades;

public class ItemModel {
    private double valorUnitario;
    private int quantidade;
    private boolean essencial;

    public ItemModel(String nome, double valorUnitario, int quantidade, boolean essencial) {
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.essencial = essencial;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isEssencial() {
        return essencial;
    }

    public double calcularCustoTotal() {
        return valorUnitario * quantidade;
    }
}