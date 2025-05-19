package com.projarc.assignment1.dominio.validacoes;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public interface IEndereco {
    IEndereco linkWith(IEndereco next);
    void check(OrcamentoModel orcamento);
}