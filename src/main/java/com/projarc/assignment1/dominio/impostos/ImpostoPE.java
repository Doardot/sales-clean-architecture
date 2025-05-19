package com.projarc.assignment1.auxiliar;

import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

import java.util.ArrayList;
import java.util.List;

public class ImpostoPE implements IImposto{
    @Override
    public double calcularImposto(OrcamentoModel orcamento){
        double valorImposto = 0;
        List<ItemPedidoModel> pedidos = orcamento.getItens();

        for(ItemPedidoModel item : pedidos) {
            if(item.getProduto().isEssencial()){
                valorImposto += (item.getProduto().getPrecoUnitario() * 0.05) * item.getQuantidade();
            }
            else
            {
                valorImposto += (item.getProduto().getPrecoUnitario() * 0.15) * item.getQuantidade();
            }
        }

        return valorImposto;
    }
}
