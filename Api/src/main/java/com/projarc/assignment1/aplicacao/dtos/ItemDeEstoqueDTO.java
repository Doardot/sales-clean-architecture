package com.projarc.assignment1.aplicacao.dtos;

import com.projarc.assignment1.dominio.entidades.ItemDeEstoqueModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDeEstoqueDTO {
    private int quantidadeAtual;
    private final ProdutoDTO produto;

    public static ItemDeEstoqueDTO fromModel(ItemDeEstoqueModel item){
        return new ItemDeEstoqueDTO(item.getQuantidadeAtual(), ProdutoDTO.fromModel(item.getProduto()));
    }
}