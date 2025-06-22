package com.receita.service.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;
import com.receita.service.dominio.entidades.ReceitaOrcamentoModel;
import com.receita.service.dominio.servicos.ServicoDeReceita;
import com.receita.service.aplicacao.dtos.ReceitaOrcamentoDTO;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SalvarReceitaOrcamentoUC {
    private final ServicoDeReceita servicoDeReceita;

    public double run(ReceitaOrcamentoDTO receitaOrcamentoDTO) {
        ReceitaOrcamentoModel receitaOrcamentoModel = new ReceitaOrcamentoModel(
            receitaOrcamentoDTO.getId(),
            receitaOrcamentoDTO.getData(),
            receitaOrcamentoDTO.getImpostoEstadual(),
            receitaOrcamentoDTO.getImpostoFederal(),
            receitaOrcamentoDTO.getValorFinal()
        );

        return servicoDeReceita.SalvarReceitaOrcamento(receitaOrcamentoModel);
    }
}
