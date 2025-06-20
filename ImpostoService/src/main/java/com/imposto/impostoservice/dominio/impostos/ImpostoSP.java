package com.imposto.impostoservice.dominio.impostos;

import java.util.ArrayList;

import com.imposto.impostoservice.dominio.entidades.ItemModel;

public class ImpostoSP implements IImposto {
    @Override
    public double calcularImposto(ArrayList<ItemModel> itens){
        double valorTotalItens = 0;

        for(ItemModel item : itens) {
            valorTotalItens += item.calcularCustoTotal();
        }

        return valorTotalItens * 0.12;
    }
}
