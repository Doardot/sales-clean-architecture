package com.projarc.assignment1.aplicacao.dtos;

import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {
    private long idProduto;
    private int qtdade;

    @Override
    public String toString() {
        return "ItemPedidoDTO [idProduto=" + idProduto + ", qtdade=" + qtdade + "]";
    }    

    public static ItemPedidoDTO fromModel(ItemPedidoModel item){
        return new ItemPedidoDTO(item.getProduto().getId(),item.getQuantidade());
    }
}
