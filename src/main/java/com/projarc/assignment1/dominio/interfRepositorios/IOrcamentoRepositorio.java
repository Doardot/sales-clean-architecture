package com.projarc.assignment1.dominio.interfRepositorios;

import java.time.LocalDate;
import java.util.List;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import org.springframework.cglib.core.Local;

public interface IOrcamentoRepositorio {
    void marcaComoEfetivado(long id); 
    void marcaComoCancelado(long id); // caso passe o prazo de validade

    OrcamentoModel cadastraOrcamento(OrcamentoModel orcamento);
    OrcamentoModel recuperaOrcamentoPorId(long id);
    List<OrcamentoModel> listarTodosOrcamentos();
    List<OrcamentoModel> listarOrcamentosPendentes();
    List<OrcamentoModel> listarOrcamentosEfetivados();
    List<OrcamentoModel> listarOrcamentosCancelados();
    List<OrcamentoModel> listarOrcamentosPorCliente(String nomeCliente);
    List<OrcamentoModel> listarOrcamentoPorPeriodo(LocalDate dataInicio, LocalDate dataFim);

    //OrcamentoModel apagaOrcamento(OrcamentoModel orcamentoModel);
}
