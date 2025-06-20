package com.imposto.impostoservice.dominio.impostos;

import java.util.ArrayList;

import com.imposto.impostoservice.dominio.entidades.ItemModel;

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
