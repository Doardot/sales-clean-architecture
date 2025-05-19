package com.projarc.assignment1.auxiliar;

import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

import java.util.List;

public class Desconto implements IDesconto {
    public double calcularDesconto(OrcamentoModel orcamento) {
        double valorDesconto = 0;
        List<ItemPedidoModel> pedidos = orcamento.getItens();

        if(pedidos.size() > 10){
            valorDesconto += orcamento.getSomatorioCustoItens() * 0.1;
        }

        for(ItemPedidoModel item : pedidos) {
            if(item.getQuantidade() > 3){
                valorDesconto += (item.getProduto().getPrecoUnitario() * 0.05) * item.getQuantidade();
            }
        }

        return valorDesconto;
    }
}
