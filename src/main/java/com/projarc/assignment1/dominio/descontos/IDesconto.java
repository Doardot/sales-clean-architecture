package com.projarc.assignment1.dominio.descontos;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public interface IDesconto {
    public double calcularDesconto(OrcamentoModel orcamento);
}
