package com.imposto.service.dominio.impostos;

import com.imposto.service.dominio.entidades.ItemModel;
import java.util.ArrayList;

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
