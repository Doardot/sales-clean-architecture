package com.projarc.assignment1.dominio.servicos;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;

public interface IServicoDeImposto {
    double calcularImposto(List<ItemPedidoModel> itens, String estado, String pais);
}
