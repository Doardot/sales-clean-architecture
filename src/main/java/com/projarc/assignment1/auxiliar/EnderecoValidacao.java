package com.projarc.assignment1.auxiliar;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public abstract class EnderecoValidacao {
    protected EnderecoValidacao next;

    public EnderecoValidacao linkWith(EnderecoValidacao next) {
        this.next = next;
        return next;
    }

    public abstract void check(OrcamentoModel orcamento);
}



//pra usar a cadeia
//EnderecoValidacao validacao = new PaisValidacao();
//validacao.linkWith(new EstadoValidacao());


//validacao.check(orcamentoModel); // Lança exceção se não for atendido