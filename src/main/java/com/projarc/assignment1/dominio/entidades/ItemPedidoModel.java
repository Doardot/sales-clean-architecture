package com.projarc.assignment1.dominio.entidades;

public class ItemPedidoModel {
    private final ProdutoModel produto;
    private final int quantidade;

    public ItemPedidoModel(ProdutoModel produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPrecoUnitario() * quantidade;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return produto.getPrecoUnitario() * quantidade;
    }

    public boolean temDescontoQuantidade() {
        return quantidade > 3;
    }

    @Override
    public String toString() {
        return "ItemPedido [produto=" + produto + ", quantidade=" + quantidade + "]";
    }
}
