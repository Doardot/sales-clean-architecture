package com.projarc.assignment1.dominio.entidades;

public class ItemDeEstoqueModel {
    private final long id;
    private final ProdutoModel produto;
    private int quantidadeAtual;
    private final int estoqueMin;
    private final int estoqueMax;

    public ItemDeEstoqueModel(long id, ProdutoModel produto, int quantidadeAtual, int estoqueMin, int estoqueMax) {
        this.id = id;
        this.produto = produto;
        this.quantidadeAtual = quantidadeAtual;
        this.estoqueMin = estoqueMin;
        this.estoqueMax = estoqueMax;
    }

    public long getId() {
        return id;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public int getEstoqueMax() {
        return estoqueMax;
    }

    public boolean possuiQuantidade(int quantidadeDesejada) {
        return quantidadeAtual >= quantidadeDesejada;
    }

    public void baixarQuantidade(int quantidade) {
        if (quantidade > quantidadeAtual) {
            throw new IllegalArgumentException("Quantidade insuficiente no estoque");
        }
        quantidadeAtual -= quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        if (quantidadeAtual + quantidade > estoqueMax) {
            throw new IllegalArgumentException("Quantidade excede o limite do estoque");
        }
        quantidadeAtual += quantidade;
    }

    @Override
    public String toString() {
        return "ItemDeEstoque [id=" + id + ", produto=" + produto + ", quantidade=" + quantidadeAtual + ", estoqueMin="
                + estoqueMin + ", estoqueMax=" + estoqueMax + "]";
    }

}