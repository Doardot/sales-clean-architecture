package com.imposto.impostoservice.dominio.servicos;

import java.util.ArrayList;

import com.imposto.impostoservice.aplicacao.dtos.OrcamentoDTO;
import com.imposto.impostoservice.dominio.entidades.ItemModel;
import com.imposto.impostoservice.dominio.factories.EstadoFactory;
import com.imposto.impostoservice.dominio.factories.PaisFactory;
import com.imposto.impostoservice.dominio.impostos.IImposto;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeImposto {
    public OrcamentoDTO calcularImposto(ArrayList<ItemModel> itens, String estado, String pais) {

        IImposto impostoFederal = PaisFactory.obterImpostoPorPais(pais);
        IImposto impostoEstadual = EstadoFactory.obterImpostoPorEstado(estado);

        double impostoFederalValor = impostoFederal.calcularImposto(itens);
        double impostoEstadualValor = impostoEstadual.calcularImposto(itens);

        OrcamentoDTO orcamentoDTO = new OrcamentoDTO(impostoFederalValor, impostoEstadualValor);

        return orcamentoDTO;
    }
}