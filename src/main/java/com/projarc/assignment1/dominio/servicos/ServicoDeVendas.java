package com.projarc.assignment1.dominio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.assignment1.aplicacao.dtos.OrcamentoDTO;
import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.entidades.PedidoModel;
import com.projarc.assignment1.dominio.entidades.ProdutoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel.Status;
import com.projarc.assignment1.dominio.interfRepositorios.IEstoqueRepositorio;
import com.projarc.assignment1.dominio.interfRepositorios.IOrcamentoRepositorio;

@Service
public class ServicoDeVendas {
    private IOrcamentoRepositorio orcamentos;
    private IEstoqueRepositorio estoque;

    @Autowired
    public ServicoDeVendas(IOrcamentoRepositorio orcamentos,IEstoqueRepositorio estoque){
        this.orcamentos = orcamentos;
        this.estoque = estoque;
    }
    
    public List<ProdutoModel> produtosDisponiveis() {
        return estoque.listarTodosProdutosComEstoque();
    }

    public OrcamentoModel recuperaOrcamentoPorId(long id) {
        return this.orcamentos.recuperaOrcamentoPorId(id);
    }

    public OrcamentoModel criaOrcamento(PedidoModel pedido) {
        var novoOrcamento = new OrcamentoModel();
        novoOrcamento.addItensPedido(pedido);
        double custoItens = novoOrcamento.getItens().stream()
            .mapToDouble(it->it.getProduto().getPrecoUnitario()*it.getQuantidade())
            .sum();
        novoOrcamento.setImpostoFederal(custoItens * 0.15);
        if (novoOrcamento.getItens().size() > 5){
                novoOrcamento.setDesconto(custoItens * 0.05);
            }else{
                novoOrcamento.setDesconto(0.0);
            }
        novoOrcamento.setValorFinal(custoItens + novoOrcamento.getImpostoFederal() + novoOrcamento.getImpostoEstadual() - novoOrcamento.getDesconto());
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
}
