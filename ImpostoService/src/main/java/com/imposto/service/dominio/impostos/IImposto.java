package com.imposto.service.dominio.impostos;

import java.util.ArrayList;
import com.imposto.service.dominio.entidades.ItemModel;

public interface IImposto {
    public double calcularImposto(ArrayList<ItemModel> itens);
}

