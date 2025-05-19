package com.projarc.assignment1.dominio.descontos;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public interface IDesconto {
    double calcularDesconto(OrcamentoModel orcamento);
}
