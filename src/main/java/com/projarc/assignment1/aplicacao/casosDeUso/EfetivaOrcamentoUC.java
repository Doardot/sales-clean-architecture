package com.projarc.assignment1.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;

import com.projarc.assignment1.aplicacao.dtos.OrcamentoDTO;
import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;
import com.projarc.assignment1.dominio.servicos.ServicoDeVendas;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EfetivaOrcamentoUC {
    private final ServicoDeVendas servicoDeVendas;
    private final ServicoDeEstoque servicoDeEstoque;

    public OrcamentoDTO run(long idOrcamento) {
        return OrcamentoDTO.fromModel(servicoDeVendas.efetivaOrcamento(idOrcamento));
    }
}