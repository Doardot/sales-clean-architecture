package com.projarc.assignment1.interfaceAdaptadora.repositorios.implemRepositorios;

import java.util.List;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Orcamento;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.OrcamentoJPA_ItfRep;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.interfRepositorios.IOrcamentoRepositorio;

@Repository
@Primary
public class OrcamentoRepJPA implements IOrcamentoRepositorio {
    private OrcamentoJPA_ItfRep orcamentoRepository;

    @Override
    public List<OrcamentoModel> listarTodosOrcamentos() {
        List<Orcamento> orcamentos = orcamentoRepository.findAll();
        return orcamentos.stream()
                .map(orc -> Orcamento.toOrcamentoModel(orc))
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosPendentes() {
        // TO-DO
        return List.of();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosEfetivados() {

        return List.of();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosCancelados() {

        return List.of();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosPorCliente(String nomeCliente) {
        return List.of();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentoPorPeriodo(String dataInicio, String dataFim) {
        return List.of();
    }

    @Override
    public OrcamentoModel cadastraOrcamento(OrcamentoModel orcamento) {

        return orcamento;
    }

    @Override
    public OrcamentoModel recuperaOrcamentoPorId(long id) {

        return null;
    }

    @Override
    public void marcaComoEfetivado(long id) {

    }

    @Override
    public void marcaComoCancelado(long id) {

    }

    @Override
    public void salvarOrcamento(OrcamentoModel orcamento) {

    }

    @Override
    public void removerOrcamento(OrcamentoModel orcamento) {

    }

}
