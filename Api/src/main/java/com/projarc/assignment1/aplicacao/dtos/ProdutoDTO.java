package com.projarc.assignment1.aplicacao.dtos;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO{
    private long id;
    private String descricao;
    private double precoUnitario;
    
    public static ProdutoDTO fromModel(ProdutoModel produto){
        return new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getPrecoUnitario());
    }
}

