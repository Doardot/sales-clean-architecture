package com.imposto.impostoservice.dominio.impostos;

import java.util.ArrayList;

import com.imposto.impostoservice.dominio.entidades.ItemModel;

public interface IImposto {
    public double calcularImposto(ArrayList<ItemModel> itens);
}

