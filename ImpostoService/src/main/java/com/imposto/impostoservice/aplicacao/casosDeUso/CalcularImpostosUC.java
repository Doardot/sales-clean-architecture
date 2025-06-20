package com.imposto.impostoservice.aplicacao.casosDeUso;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.imposto.impostoservice.dominio.entidades.ItemModel;
import com.imposto.impostoservice.dominio.servicos.ServicoDeImposto;
import com.imposto.impostoservice.aplicacao.dtos.ItemModelDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CalcularImpostosUC {
    private final ServicoDeImposto servicoDeImposto;

    public double run(ArrayList<ItemModelDTO> itens, String estado, String pais) {
        ArrayList<ItemModel> itemModels = new ArrayList<>();
        for (ItemModelDTO itemDTO : itens) {
            ItemModel itemModel = new ItemModel(itemDTO.getNome(), itemDTO.getValorUnitario(), itemDTO.getQuantidade(), itemDTO.isEssencial());
            itemModels.add(itemModel);
        }

        return servicoDeImposto.calcularImposto(itemModels, estado, pais);
    }
}
