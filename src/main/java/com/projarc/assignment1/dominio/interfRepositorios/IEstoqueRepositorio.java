package com.projarc.assignment1.dominio.interfRepositorios;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;

public interface IEstoqueRepositorio {
    List<ProdutoModel> todos();
    List<ProdutoModel> todosComEstoque();
    int quantidadeEmEstoque(long codigo);
    int baixaEstoque(long codProd, int qtdade);
}
