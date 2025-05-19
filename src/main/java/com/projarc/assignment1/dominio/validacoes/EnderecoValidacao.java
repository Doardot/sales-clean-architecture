package com.projarc.assignment1.dominio.validacoes;

import com.projarc.assignment1.dominio.entidades.IEndereco;
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
