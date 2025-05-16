package com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Orcamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrcamentoJPA_ItfRep extends CrudRepository<Orcamento, Long> {
    @Override
    List<Orcamento> findAll();
    Optional<Orcamento> findById(long id);
    List<Orcamento> findByStatus(String status);
    List<Orcamento> findByClienteNome(String nomeCliente);
    List<Orcamento> findByDataCriacaoBetween(String dataInicio, String dataFim);
}
