package com.projarc.assignment1.aplicacao.dtos;

import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;

public class ItemPedidoDTO {
    private long idProduto;
    private int qtdade;

    public ItemPedidoDTO(long idProduto, int qtdade) {
        this.idProduto = idProduto;
        this.qtdade = qtdade;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public int getQtdade() {
        return qtdade;
    }

    @Override
    public String toString() {
        return "ItemPedidoDTO [idProduto=" + idProduto + ", qtdade=" + qtdade + "]";
    }    

    public static ItemPedidoDTO fromModel(ItemPedidoModel item){
        return new ItemPedidoDTO(item.getProduto().getId(),item.getQuantidade());
    }
}
