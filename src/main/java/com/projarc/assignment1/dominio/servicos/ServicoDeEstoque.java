package com.projarc.assignment1.dominio.servicos;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.ItemDeEstoqueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;
import com.projarc.assignment1.dominio.interfRepositorios.IEstoqueRepositorio;
import com.projarc.assignment1.dominio.interfRepositorios.IProdutoRepositorio;
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

    public List<ProdutoModel> produtosDisponiveis(){
        return estoque.listarTodosProdutosComEstoque();
    }

    public ProdutoModel produtoPorCodigo(long id){
        return this.produtos.consultaProdutoPorId(id);
    }

    public int aumentaEstoque(long id, int quantidade){
        int qtdEmEstoque =  estoque.quantidadeEmEstoque(id);
        int qtdMaxima = estoque.quantidadeMaximaEmEstoque(id);

        if (qtdEmEstoque + quantidade > qtdMaxima) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Quantidade máxima de produto atingida. Operação cancelada.");
        }

        return estoque.aumentaEstoque(id, quantidade);
    }

    public List<ItemDeEstoqueModel> getQuantidadeProdutos() {
        return estoque.listarEstoqueDisponivelParaTodosProdutos();
    }
    public List<ItemDeEstoqueModel> getQuantidadeProdutosSelecionados(List<Long> idProdutos) {
        return estoque.listarEstoqueDisponivelParaProdutosInformados(idProdutos);
    }

}