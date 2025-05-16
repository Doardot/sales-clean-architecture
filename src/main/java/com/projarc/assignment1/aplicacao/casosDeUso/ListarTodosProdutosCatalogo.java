package com.projarc.assignment1.aplicacao.casosDeUso;

import com.projarc.assignment1.aplicacao.dtos.ProdutoDTO;
import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarTodosProdutosCatalogo {
    private final ServicoDeEstoque servicoDeEstoque;

    public ListarTodosProdutosCatalogo(ServicoDeEstoque servicoDeEstoque) {
        this.servicoDeEstoque = servicoDeEstoque;
    }

    public List<ProdutoDTO> run() {
        return servicoDeEstoque.produtosDisponiveis().stream()
                .map(ProdutoDTO::fromModel)
                .toList();
    }
}
