package com.projarc.assignment1.aplicacao.casosDeUso;

import com.projarc.assignment1.aplicacao.dtos.ItemDeEstoqueDTO;
import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarQtdProdutosSelecionadosUC {
    private final ServicoDeEstoque servicoEstoque;

    public ListarQtdProdutosSelecionadosUC(ServicoDeEstoque servicoEstoque){
        this.servicoEstoque = servicoEstoque;
    }

    public List<ItemDeEstoqueDTO> run(List<Long> idProdutos){
        return servicoEstoque.getQuantidadeProdutosSelecionados(idProdutos).stream()
                .map(ItemDeEstoqueDTO::fromModel)
                .toList();
    }
}
