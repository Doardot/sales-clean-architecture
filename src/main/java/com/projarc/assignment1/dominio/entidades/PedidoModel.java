package com.projarc.assignment1.dominio.entidades;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

@Getter
public class PedidoModel {
    private long id;
    private final List<ItemPedidoModel> itens;

    public PedidoModel() {
        this.itens = new LinkedList<>();
    }

    public void addItem(ItemPedidoModel item){
        itens.add(item);
    }
}
