package com.projarc.assignment1.dominio.entidades;

public class ProdutoModel {
    private final long id;
    private final String descricao;
    private final double precoUnitario;

    public ProdutoModel(long id, String descricao, double precoUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
    }

    public long getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getPrecoUnitario() {
        return this.precoUnitario;
    }

    public boolean isEssencial() {
        return descricao != null && descricao.trim().endsWith("*");
    }

    @Override
    public String toString() {
        return "{" +
                " codigo='" + getId() + "'" +
                ", descricao='" + getDescricao() + "'" +
                ", precoUnitario='" + getPrecoUnitario() + "'" +
                "}";
    }
}