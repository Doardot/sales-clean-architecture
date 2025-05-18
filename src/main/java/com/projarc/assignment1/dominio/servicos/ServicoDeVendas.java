package com.projarc.assignment1.dominio.servicos;

import java.util.List;

import com.projarc.assignment1.auxiliar.*;
import com.projarc.assignment1.dominio.entidades.EnderecoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.entidades.PedidoModel;
import com.projarc.assignment1.dominio.entidades.ProdutoModel;
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

    public OrcamentoModel criaOrcamento(PedidoModel pedido, String pais, String estado) {
        EnderecoModel endereco = new EnderecoModel(estado, pais);
        OrcamentoModel novoOrcamento = new OrcamentoModel(0);
        novoOrcamento.setEndereco(endereco);
        novoOrcamento.addItensPedido(pedido);

        IEndereco validadorEndereco = new PaisValidacao();
        validadorEndereco.linkWith(new EstadoValidacao());
        validadorEndereco.check(novoOrcamento);

        double custoItens = novoOrcamento.getItens().stream()
                .mapToDouble(it -> it.getProduto().getPrecoUnitario() * it.getQuantidade())
                .sum();
        novoOrcamento.setSomatorioCustoItens(custoItens);

        IImposto impostoFederal = new ImpostoFederal();
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
        // Recupera o orçamento
    
        // Verifica se tem quantidade em estoque para todos os itens

        // Se tem quantidade para todos os itens, da baixa no estoque para todos

        // Marca o orcamento como efetivado

        // Retorna o orçamento marcado como efetivado ou não conforme disponibilidade do estoque
        return null;
    }
}
