package com.imposto.service.dominio.impostos;

import com.imposto.service.dominio.entidades.ItemModel;
import java.util.ArrayList;

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
