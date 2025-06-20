package com.projarc.assignment1.dominio.entidades;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.ItemDeEstoque;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Produto;
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

    public static ItemDeEstoqueModel toItemDeEstoqueModel(ItemDeEstoque item){
        return new ItemDeEstoqueModel(item.getId(), item.getQuantidade(), item.getEstoqueMin(), item.getEstoqueMax(), Produto.toProdutoModel(item.getProduto()));
    }
}