package com.projarc.assignment1.dominio.descontos;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public class Desconto implements IDesconto {
    @Override
    public double calcularDesconto(OrcamentoModel orcamento) {
        // Usa o método calcularTotalBruto() já existente em OrcamentoModel
        if (orcamento.calcularTotalBruto() > 1000) {
            return orcamento.calcularTotalBruto() * 0.05; // 5% de desconto
        }
        return 0;
    }
}
