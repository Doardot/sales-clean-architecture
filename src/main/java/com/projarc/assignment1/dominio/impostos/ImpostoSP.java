package com.projarc.assignment1.auxiliar;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public class ImpostoSP implements IImposto {
    @Override
    public double calcularImposto(OrcamentoModel orcamento){
        return orcamento.getSomatorioCustoItens() * 0.12;
    }
}
