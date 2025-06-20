package com.projarc.assignment1.aplicacao.casosDeUso;

import com.projarc.assignment1.aplicacao.dtos.ItemDeEstoqueDTO;
import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarQtdProdutosUC {
    private final ServicoDeEstoque servicoEstoque;

    public ListarQtdProdutosUC(ServicoDeEstoque servicoEstoque){
        this.servicoEstoque = servicoEstoque;
    }

    public List<ItemDeEstoqueDTO> run(){
        return servicoEstoque.getQuantidadeProdutos().stream()
                .map(ItemDeEstoqueDTO::fromModel)
                .toList();
    }
}
