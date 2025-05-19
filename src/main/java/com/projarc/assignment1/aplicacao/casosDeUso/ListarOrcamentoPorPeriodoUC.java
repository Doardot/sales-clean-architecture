package com.projarc.assignment1.aplicacao.casosDeUso;

import com.projarc.assignment1.aplicacao.dtos.OrcamentoDTO;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.servicos.ServicoDeVendas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarOrcamentoPorPeriodoUC {
    private final ServicoDeVendas servicoDeVendas;

    public List<OrcamentoDTO> run(LocalDate dataInicio, LocalDate dataFim) {
        List<OrcamentoModel> orcamentos = servicoDeVendas.listarOrcamentoPorPeriodo(dataInicio, dataFim);
        return orcamentos.stream().map(OrcamentoDTO::fromModel).toList();
    }
}
