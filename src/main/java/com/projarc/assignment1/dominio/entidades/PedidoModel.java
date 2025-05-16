package com.projarc.assignment1.dominio.entidades;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

@Getter
public class PedidoModel {
    private final long id;
    private final List<ItemPedidoModel> itens;

    public PedidoModel(long id) {
        this.id = id;
        this.itens = new LinkedList<>();
    }

    public void addItem(ItemPedidoModel item){
        itens.add(item);
    }

    public void removeItem(ItemPedidoModel item){
        itens.remove(item);
    }
}
