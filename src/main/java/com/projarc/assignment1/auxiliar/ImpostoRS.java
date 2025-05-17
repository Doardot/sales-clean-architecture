package com.projarc.assignment1.auxiliar;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public class ImpostoRS implements IImposto {
    @Override
    public double calcularImposto(OrcamentoModel orcamento){
        if(orcamento.getSomatorioCustoItens()>100){
            return (orcamento.getSomatorioCustoItens() - 100) * 0.10;
        } else {
            return 0;
        }
    }
}
