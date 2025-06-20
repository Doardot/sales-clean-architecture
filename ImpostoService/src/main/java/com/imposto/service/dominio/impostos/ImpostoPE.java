package com.imposto.service.dominio.impostos;

import com.imposto.service.dominio.entidades.ItemModel;
import java.util.ArrayList;

public class ImpostoPE implements IImposto{
    @Override
    public double calcularImposto(ArrayList<ItemModel> itens){
        double valorImposto = 0;

        for(ItemModel item : itens) {
            if(item.isEssencial()){
                valorImposto += (item.getValorUnitario() * 0.05) * item.getQuantidade();
            }
            else
            {
                valorImposto += (item.getValorUnitario() * 0.15) * item.getQuantidade();
            }
        }

        return valorImposto;
    }
}
