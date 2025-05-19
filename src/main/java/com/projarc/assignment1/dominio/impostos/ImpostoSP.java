package com.projarc.assignment1.dominio.impostos;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public class ImpostoSP implements IImposto {
    @Override
    public double calcularImposto(OrcamentoModel orcamento) {
        // Usa o método calcularTotalBruto() já existente em OrcamentoModel
        return orcamento.calcularTotalBruto() * 0.04;
    }
}
