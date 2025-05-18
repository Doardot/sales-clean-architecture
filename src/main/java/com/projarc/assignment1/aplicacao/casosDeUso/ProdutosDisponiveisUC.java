package com.projarc.assignment1.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.assignment1.aplicacao.dtos.ProdutoDTO;
import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;

@Component
public class ProdutosDisponiveisUC {
    private final ServicoDeEstoque servicoEstoque;

    public ProdutosDisponiveisUC(ServicoDeEstoque servicoEstoque){
        this.servicoEstoque = servicoEstoque;
    }

    public List<ProdutoDTO> run(){
        return servicoEstoque.produtosDisponiveis().stream()
            .map(ProdutoDTO::fromModel)
            .toList();
    }
}
