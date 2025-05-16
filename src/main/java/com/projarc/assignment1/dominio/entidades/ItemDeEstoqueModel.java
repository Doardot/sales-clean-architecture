package com.projarc.assignment1.dominio.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ItemDeEstoqueModel {
    private final long id;
    private int quantidadeAtual;
    private final int quantidadeMin;
    private final int quantidadeMax;
    private final ProdutoModel produto;

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
        if (quantidadeAtual + quantidade > quantidadeMax) {
            throw new IllegalArgumentException("Quantidade excede o limite do estoque");
        }
        quantidadeAtual += quantidade;
    }
}