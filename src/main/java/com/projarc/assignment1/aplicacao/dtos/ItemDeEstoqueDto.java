package com.projarc.assignment1.aplicacao.dtos;

import com.projarc.assignment1.dominio.entidades.ItemDeEstoqueModel;
import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import com.projarc.assignment1.dominio.entidades.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDeEstoqueDto {
    private int quantidadeAtual;
    private final ProdutoDTO produto;

    public static ItemDeEstoqueDto fromModel(ItemDeEstoqueModel item){
        return new ItemDeEstoqueDto(item.getQuantidadeAtual(), ProdutoDTO.fromModel(item.getProduto()));
    }
}