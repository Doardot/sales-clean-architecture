package com.projarc.assignment1.dominio.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoModel {
    private final long id;
    private final String descricao;
    private final double precoUnitario;

    public boolean isEssencial() {
        return descricao != null && descricao.trim().endsWith("*");
    }
}