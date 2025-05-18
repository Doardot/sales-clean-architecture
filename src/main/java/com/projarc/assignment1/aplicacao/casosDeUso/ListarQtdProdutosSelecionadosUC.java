package com.projarc.assignment1.aplicacao.casosDeUso;

import com.projarc.assignment1.aplicacao.dtos.ItemDeEstoqueDto;
import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarQtdProdutosSelecionadosUC {
    private final ServicoDeEstoque servicoEstoque;

    public ListarQtdProdutosSelecionadosUC(ServicoDeEstoque servicoEstoque){
        this.servicoEstoque = servicoEstoque;
    }

    public List<ItemDeEstoqueDto> run(List<Long> idProdutos){
        return servicoEstoque.getQuantidadeProdutosSelecionados(idProdutos).stream()
                .map(ItemDeEstoqueDto::fromModel)
                .toList();
    }
}
