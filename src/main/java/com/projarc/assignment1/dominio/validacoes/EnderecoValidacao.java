package com.projarc.assignment1.auxiliar;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public abstract class EnderecoValidacao implements IEndereco {
    protected IEndereco next;

    @Override
    public IEndereco linkWith(IEndereco next) {
        this.next = next;
        return next;
    }

    @Override
    public abstract void check(OrcamentoModel orcamento);
}
