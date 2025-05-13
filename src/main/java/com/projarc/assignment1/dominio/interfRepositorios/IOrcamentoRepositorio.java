package com.projarc.assignment1.dominio.interfRepositorios;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public interface IOrcamentoRepositorio {
    List<OrcamentoModel> todos();
    OrcamentoModel cadastra(OrcamentoModel orcamento);
    OrcamentoModel recuperaPorId(long id);
    void marcaComoEfetivado(long id); 
}
