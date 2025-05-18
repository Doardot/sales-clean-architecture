package com.projarc.assignment1.dominio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;
import com.projarc.assignment1.dominio.interfRepositorios.IEstoqueRepositorio;
import com.projarc.assignment1.dominio.interfRepositorios.IProdutoRepositorio;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoDeEstoque{
    private IEstoqueRepositorio estoque;
    private IProdutoRepositorio produtos;
    
    @Autowired
    public ServicoDeEstoque(IProdutoRepositorio produtos,IEstoqueRepositorio estoque){
        this.produtos = produtos;
        this.estoque = estoque;
    }

    public List<ProdutoModel> todosProdutosCatalogo(){
        return produtos.listarTodosProdutos();
    }

    public List<ProdutoModel> produtosDisponiveis(){
        return estoque.listarTodosProdutosComEstoque();
    }

    public List<ProdutoModel> produtosEsgotados(){
        return estoque.listarTodosProdutosEsgotados();
    }

    public ProdutoModel produtoPorCodigo(long id){
        return this.produtos.consultaProdutoPorId(id);
    }

    public int quantidadeEmEstoque(long id){
        return estoque.quantidadeEmEstoque(id);
    }

    public void baixaEstoque(long id, int quantidade){
        estoque.baixaEstoque(id, quantidade);
    }

    public int aumentaEstoque(long id, int quantidade){
        int qtdEmEstoque =  estoque.quantidadeEmEstoque(id);
        int qtdMaxima = estoque.quantidadeMaximaEmEstoque(id);

        if (qtdEmEstoque + quantidade > qtdMaxima) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Quantidade máxima de produto atingida. Operação cancelada.");
        }

        return estoque.aumentaEstoque(id, quantidade);
    }
}
