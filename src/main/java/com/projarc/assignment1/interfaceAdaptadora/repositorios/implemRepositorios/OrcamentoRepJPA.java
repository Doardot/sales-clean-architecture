package com.projarc.assignment1.interfaceAdaptadora.repositorios.implemRepositorios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Endereco;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Orcamento;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.OrcamentoJPA_ItfRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.interfRepositorios.IOrcamentoRepositorio;

@Repository
@Primary
public class OrcamentoRepJPA implements IOrcamentoRepositorio {
    private final OrcamentoJPA_ItfRep orcamentoRepository;

    @Autowired
    public OrcamentoRepJPA(OrcamentoJPA_ItfRep orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    @Override
    public List<OrcamentoModel> listarTodosOrcamentos() {
        List<Orcamento> orcamentos = orcamentoRepository.findAll();
        return orcamentos.stream()
                 .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosPendentes() {
        List<Orcamento> orcamentos = orcamentoRepository.findByStatus(OrcamentoModel.Status.PENDENTE);
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosEfetivados() {
        List<Orcamento> orcamentos = orcamentoRepository.findByStatus(OrcamentoModel.Status.EFETIVADO);
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosCancelados() {
        List<Orcamento> orcamentos = orcamentoRepository.findByStatus(OrcamentoModel.Status.CANCELADO);
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentosPorCliente(String nomeCliente) {
        List<Orcamento> orcamentos = orcamentoRepository.findByNomeCliente(nomeCliente);
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public List<OrcamentoModel> listarOrcamentoPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        List<Orcamento> orcamentos = orcamentoRepository.findByDataBetween(dataInicio, dataFim);
        return orcamentos.stream()
                .map(Orcamento::toOrcamentoModel)
                .toList();
    }

    @Override
    public OrcamentoModel cadastraOrcamento(OrcamentoModel orcamento) {
        Endereco enderecoEntity = new Endereco(
                orcamento.getEndereco().getEstado(),
                orcamento.getEndereco().getPais()
        );
        Orcamento orcamentoEntity = new Orcamento();
    //    orcamentoEntity.setId(orcamento.getId());
        orcamentoEntity.setData(orcamento.getData());
        orcamentoEntity.setNomeCliente(orcamento.getNomeCliente());
        orcamentoEntity.setEndereco(enderecoEntity);
        orcamentoEntity.setSomatorioCustoItens(orcamento.getSomatorioCustoItens());
        orcamentoEntity.setImpostoEstadual(orcamento.getImpostoEstadual());
        orcamentoEntity.setImpostoFederal(orcamento.getImpostoFederal());
        orcamentoEntity.setDesconto(orcamento.getDesconto());
        orcamentoEntity.setValorFinal(orcamento.getValorFinal());
        orcamentoEntity.setStatus(orcamento.getStatus());
        
        List<ItemPedido> itens = orcamento.getItens().stream()
                .map(ItemPedido::fromItemPedidoModel)
                .collect(Collectors.toList());
        orcamentoEntity.setItens(itens);

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
