package com.projarc.assignment1.dominio.interfRepositorios;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;

public interface IEstoqueRepositorio {
    int quantidadeEmEstoque(long codigo);
    int baixaEstoque(long codProd, int qtdade);
    int aumentaEstoque(long codProd, int qtdade);
    List<ProdutoModel> listarTodosProdutos();
    List<ProdutoModel> listarTodosProdutosComEstoque();
    List<ProdutoModel> listarTodosProdutosEsgotados();
    List<ProdutoModel> listarEstoqueDisponivelParaProdutosInformados(List<ProdutoModel> produtos);

    // seed
    void salvarProduto(ProdutoModel produto);
    void removerProduto(ProdutoModel produto);
}
