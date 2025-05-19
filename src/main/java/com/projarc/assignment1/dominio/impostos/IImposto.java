package com.projarc.assignment1.dominio.impostos;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public interface IImposto {
    public double calcularImposto(OrcamentoModel orcamento);
}

