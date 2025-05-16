package com.projarc.assignment1.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemPedidoModel {
    private final ProdutoModel produto;
    private final int quantidade;

    public double calcularSubtotal() {
        return produto.getPrecoUnitario() * quantidade;
    }

    public boolean temDescontoQuantidade() {
        return quantidade > 3;
    }
}
