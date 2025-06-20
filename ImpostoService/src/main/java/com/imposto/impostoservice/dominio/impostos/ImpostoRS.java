package com.imposto.impostoservice.dominio.impostos;

import java.util.ArrayList;

import com.imposto.impostoservice.dominio.entidades.ItemModel;

public class ImpostoRS implements IImposto {
    @Override
    public double calcularImposto(ArrayList<ItemModel> itens){
        double valorTotalItens = 0;

        for(ItemModel item : itens) {
            valorTotalItens += item.calcularCustoTotal();
        }

        if(valorTotalItens > 100) {
            return (valorTotalItens - 100) * 0.10;
        } else {
            return 0;
        }
    }
}
