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
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosPendentes() {
        List<Orcamento> orcamentos = orcamentoRepository.findByStatus("PENDENTE");
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosEfetivados() {
        List<Orcamento> orcamentos = orcamentoRepository.findByStatus("EFETIVADO");
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosCancelados() {
        List<Orcamento> orcamentos = orcamentoRepository.findByStatus("CANCELADO");
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosPorCliente(String nomeCliente) {
        List<Orcamento> orcamentos = orcamentoRepository.findByClienteNome(nomeCliente);
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentoPorPeriodo(String dataInicio, String dataFim) {
        List<Orcamento> orcamentos = orcamentoRepository.findByDataCriacaoBetween(dataInicio, dataFim);
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public OrcamentoModel cadastraOrcamento(OrcamentoModel orcamento) {
        Orcamento orcamentoEntity = new Orcamento();
        orcamentoEntity.setId(orcamento.getId());
        orcamentoEntity.setData(orcamento.getData());
        orcamentoEntity.setNomeCliente(orcamento.getNomeCliente());
        orcamentoEntity.setEstado(orcamento.getEstado());
        orcamentoEntity.setPais(orcamento.getPais());
        orcamentoEntity.setSomatorioCustoItens(orcamento.getSomatorioCustoItens());
        orcamentoEntity.setImpostoEstadual(orcamento.getImpostoEstadual());
        orcamentoEntity.setImpostoFederal(orcamento.getImpostoFederal());
        orcamentoEntity.setDesconto(orcamento.getDesconto());
        orcamentoEntity.setValorFinal(orcamento.getValorFinal());
        orcamentoEntity.setStatus(orcamento.getStatus());

        return Orcamento.toOrcamentoModel(orcamentoRepository.save(orcamentoEntity));
    }

    @Override
    public OrcamentoModel recuperaOrcamentoPorId(long id) {
        return orcamentoRepository.findById(id)
                .map(Orcamento::toOrcamentoModel)
                .orElse(null);
    }

    @Override
    public void marcaComoEfetivado(long id) {
        Orcamento orcamento = orcamentoRepository.findById(id).orElse(null);
        if (orcamento != null) {
            orcamento.setStatus(OrcamentoModel.Status.EFETIVADO);
            orcamentoRepository.save(orcamento);
        }
    }

    @Override
    public void marcaComoCancelado(long id) {
        Orcamento orcamento = orcamentoRepository.findById(id).orElse(null);
        if (orcamento != null) {
            orcamento.setStatus(OrcamentoModel.Status.CANCELADO);
            orcamentoRepository.save(orcamento);
        }
    }
}
