package com.imposto.impostoservice.dominio.servicos;

import java.util.ArrayList;

import com.imposto.impostoservice.aplicacao.dtos.ItemModelDTO;
import com.imposto.impostoservice.dominio.entidades.ItemModel;
import com.imposto.impostoservice.dominio.factories.EstadoFactory;
import com.imposto.impostoservice.dominio.factories.PaisFactory;
import com.imposto.impostoservice.dominio.impostos.IImposto;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeImposto {
    public double calcularImposto(ArrayList<ItemModelDTO> itens, String estado, String pais) {

        IImposto impostoFederal = PaisFactory.obterImpostoPorPais(pais);
        IImposto impostoEstadual = EstadoFactory.obterImpostoPorEstado(estado);

        // DTO -> Modelo
        ArrayList<ItemModel> itemModels = new ArrayList<>();
        for (ItemModelDTO itemDTO : itens) {
            ItemModel itemModel = new ItemModel(itemDTO.getNome(), itemDTO.getValorUnitario(), itemDTO.getQuantidade(), itemDTO.isEssencial());
            itemModels.add(itemModel);
        }

        double impostoFederalValor = impostoFederal.calcularImposto(itemModels);
        double impostoEstadualValor = impostoEstadual.calcularImposto(itemModels);

        return (impostoFederalValor + impostoEstadualValor);
    }
}