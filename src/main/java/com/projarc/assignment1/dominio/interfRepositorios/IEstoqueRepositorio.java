package com.projarc.assignment1.dominio.interfRepositorios;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.ItemDeEstoqueModel;
import com.projarc.assignment1.dominio.entidades.ProdutoModel;

public interface IEstoqueRepositorio {
    int quantidadeEmEstoque(long codigo);
    int quantidadeMinimaEmEstoque(long codigo);
    int quantidadeMaximaEmEstoque(long codigo);
    int baixaEstoque(long codProd, int qtdade);
    int aumentaEstoque(long codProd, int qtdade);
    List<ProdutoModel> listarTodosProdutosComEstoque();
    List<ItemDeEstoqueModel> listarEstoqueDisponivelParaTodosProdutos();
    List<ItemDeEstoqueModel> listarEstoqueDisponivelParaProdutosInformados(List<Long> produtos);
}
