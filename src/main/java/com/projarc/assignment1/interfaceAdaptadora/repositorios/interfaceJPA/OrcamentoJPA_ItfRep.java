package com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Orcamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrcamentoJPA_ItfRep extends CrudRepository<Orcamento, Long> {
    @Override
    List<Orcamento> findAll();
    OrcamentoJPA_ItfRep findById(long id);
    List<OrcamentoJPA_ItfRep> findByStatus(String status);
    List<OrcamentoJPA_ItfRep> findByClienteNome(String nomeCliente);
    List<OrcamentoJPA_ItfRep> findByDataCriacaoBetween(String dataInicio, String dataFim);
}
