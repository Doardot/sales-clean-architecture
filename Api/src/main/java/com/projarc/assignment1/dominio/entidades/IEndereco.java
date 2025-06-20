package com.projarc.assignment1.dominio.entidades;

public interface IEndereco {
    IEndereco linkWith(IEndereco next);
    void check(OrcamentoModel orcamento);
}