package com.projarc.assignment1.dominio.servicos;

import java.time.LocalDate;
import java.util.List;

import com.projarc.assignment1.dominio.descontos.Desconto;
import com.projarc.assignment1.dominio.descontos.IDesconto;
import com.projarc.assignment1.dominio.entidades.EnderecoModel;
import com.projarc.assignment1.dominio.factories.EstadoFactory;
import com.projarc.assignment1.dominio.factories.PaisFactory;
import com.projarc.assignment1.dominio.impostos.IImposto;
import com.projarc.assignment1.dominio.validacoes.EstadoValidacao;
import com.projarc.assignment1.dominio.validacoes.PaisValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.entidades.PedidoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel.Status;
import com.projarc.assignment1.dominio.interfRepositorios.IEstoqueRepositorio;
import com.projarc.assignment1.dominio.interfRepositorios.IOrcamentoRepositorio;
import com.projarc.assignment1.dominio.entidades.IEndereco;

@Service
public class ServicoDeVendas {
    private IOrcamentoRepositorio orcamentos;
    private IEstoqueRepositorio estoque;

    @Autowired
    public ServicoDeVendas(IOrcamentoRepositorio orcamentos,IEstoqueRepositorio estoque){
        this.orcamentos = orcamentos;
        this.estoque = estoque;
    }

    public OrcamentoModel recuperaOrcamentoPorId(long id) {
        return this.orcamentos.recuperaOrcamentoPorId(id);
    }

    public OrcamentoModel criaOrcamento(PedidoModel pedido, String pais, String estado, String nomeCliente) {
        EnderecoModel endereco = new EnderecoModel(estado, pais);
        OrcamentoModel novoOrcamento = new OrcamentoModel();
        novoOrcamento.setEndereco(endereco);
        novoOrcamento.setNomeCliente(nomeCliente);
        novoOrcamento.addItensPedido(pedido);

        IEndereco validadorEndereco = new PaisValidacao();
        validadorEndereco.linkWith(new EstadoValidacao());
        validadorEndereco.check(novoOrcamento);

        double custoItens = novoOrcamento.getItens().stream()
                .mapToDouble(it -> it.getProduto().getPrecoUnitario() * it.getQuantidade())
                .sum();
        novoOrcamento.setSomatorioCustoItens(custoItens);

        IImposto impostoFederal = PaisFactory.obterImpostoPorPais(pais);
        novoOrcamento.setImpostoFederal(impostoFederal.calcularImposto(novoOrcamento));

        IImposto impostoEstadual = EstadoFactory.obterImpostoPorEstado(estado);
        novoOrcamento.setImpostoEstadual(impostoEstadual.calcularImposto(novoOrcamento));

        IDesconto desconto = new Desconto();
        double valorDesconto = desconto.calcularDesconto(novoOrcamento);
        novoOrcamento.setDesconto(valorDesconto);

        novoOrcamento.setValorFinal(
                custoItens + novoOrcamento.getImpostoFederal() + novoOrcamento.getImpostoEstadual() - valorDesconto
        );

        return this.orcamentos.cadastraOrcamento(novoOrcamento);
    }
 
    public OrcamentoModel efetivaOrcamento(long id) {
        OrcamentoModel orcamento = this.recuperaOrcamentoPorId(id);

        if (orcamento.getStatus() == Status.EFETIVADO) {
            return orcamento;
        }

        if (!orcamento.estaValido()) {

            orcamentos.marcaComoCancelado(id);
            return this.recuperaOrcamentoPorId(id);
        }

        for (ItemPedidoModel item : orcamento.getItens()) {
            int qtdEmEstoque = this.estoque.quantidadeEmEstoque(item.getProduto().getId());
            int estoqueMinimo = this.estoque.quantidadeMinimaEmEstoque(item.getProduto().getId());
            if (qtdEmEstoque - item.getQuantidade() < estoqueMinimo) {
                orcamentos.marcaComoCancelado(id);
                return this.recuperaOrcamentoPorId(id);
            }
        }

        for (ItemPedidoModel item : orcamento.getItens()) {
            this.estoque.baixaEstoque(item.getProduto().getId(), item.getQuantidade());
        }

        orcamentos.marcaComoEfetivado(id);
        return this.recuperaOrcamentoPorId(id);

    }

    public List<OrcamentoModel> listarOrcamentoPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        return this.orcamentos.listarOrcamentoPorPeriodo(dataInicio, dataFim);
    }
}
