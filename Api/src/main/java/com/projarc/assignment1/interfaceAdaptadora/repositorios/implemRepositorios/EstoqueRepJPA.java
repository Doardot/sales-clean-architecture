package com.projarc.assignment1.interfaceAdaptadora.repositorios.implemRepositorios;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.ItemDeEstoqueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;
import com.projarc.assignment1.dominio.interfRepositorios.IEstoqueRepositorio;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.ItemDeEstoque;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Produto;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.EstoqueJPA_ItfRep;


@Repository
@Primary
public class EstoqueRepJPA implements IEstoqueRepositorio{
    private final EstoqueJPA_ItfRep estoqueRepository;

    @Autowired
    public EstoqueRepJPA(EstoqueJPA_ItfRep estoque){
        this.estoqueRepository = estoque;
    }

    @Override
    public List<ProdutoModel> listarTodosProdutosComEstoque() {
        List<ItemDeEstoque> itens = estoqueRepository.findAll();
        return itens.stream()
                .filter(it->it.getQuantidade()>0)
                .map(it->Produto.toProdutoModel(it.getProduto()))
                .toList();
    }

    @Override
    public List<ItemDeEstoqueModel> listarEstoqueDisponivelParaTodosProdutos() {
        List<ItemDeEstoque> itens = estoqueRepository.findAll();
        return itens.stream()
                .filter(it->it.getQuantidade()>0)
                .map(ItemDeEstoqueModel::toItemDeEstoqueModel)
                .toList();
    }

    @Override
    public List<ItemDeEstoqueModel> listarEstoqueDisponivelParaProdutosInformados(List<Long> idProdutos) {
        List<ItemDeEstoque> itens = estoqueRepository.findAll();
        return itens.stream()
                .filter(it->idProdutos.contains(it.getId()))
                .filter(it->it.getQuantidade()>0)
                .map(ItemDeEstoqueModel::toItemDeEstoqueModel)
                .toList();
    }

    @Override
    public int quantidadeEmEstoque(long codigo) {
        ItemDeEstoque item = estoqueRepository.findById(codigo).orElse(null);
        if (item == null){
            return -1;
        }else{
            return item.getQuantidade();
        }
    }

    @Override
    public int quantidadeMaximaEmEstoque(long codigo) {
        ItemDeEstoque item = estoqueRepository.findById(codigo).orElse(null);
        if (item == null){
            return -1;
        }else{
            return item.getEstoqueMax();
        }
    }

    @Override
    public int quantidadeMinimaEmEstoque(long codigo) {
        ItemDeEstoque item = estoqueRepository.findById(codigo).orElse(null);
        if (item == null){
            return -1;
        }else{
            return item.getEstoqueMin();
        }
    }

    @Override
    public int baixaEstoque(long codProd, int qtdade) {
        ItemDeEstoque item = estoqueRepository.findById(codProd).orElse(null);
        if (item == null){
            throw new IllegalArgumentException("Produto inexistente");
        }
        if (item.getQuantidade() < qtdade){
            throw new IllegalArgumentException("Quantidade em estoque insuficiente");
        }
        int novaQuantidade = item.getQuantidade() - qtdade;
        item.setQuantidade(novaQuantidade);
        estoqueRepository.save(item);
        return novaQuantidade;
    }

    @Override
    public int aumentaEstoque(long codProd, int qtdade) {
        ItemDeEstoque item = estoqueRepository.findById(codProd).orElse(null);
        if (item == null){
            throw new IllegalArgumentException("Produto inexistente");
        }
        if (item.getQuantidade() + qtdade > item.getEstoqueMax()){
            throw new IllegalArgumentException("Quantidade em estoque excede o limite");
        }
        int novaQuantidade = item.getQuantidade() + qtdade;
        item.setQuantidade(novaQuantidade);
        estoqueRepository.save(item);
        return novaQuantidade;
    }
}
