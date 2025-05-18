package com.projarc.assignment1.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;

import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AdicionaProdutoUC {
    private final ServicoDeEstoque servicoDeEstoque;

    public int run(long idProduto, int qtdProduto) {
        return servicoDeEstoque.aumentaEstoque(idProduto, qtdProduto);
    }
}
