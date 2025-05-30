package com.projarc.assignment1.interfaceAdaptadora.repositorios.implemRepositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;
import com.projarc.assignment1.dominio.interfRepositorios.IProdutoRepositorio;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Produto;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.ProdutoJPA_ItfRep;

@Repository
@Primary
public class ProdutoRepJPA implements IProdutoRepositorio {
    private ProdutoJPA_ItfRep produtoRepository;

    @Autowired
    public ProdutoRepJPA(ProdutoJPA_ItfRep produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoModel consultaProdutoPorId(long id) {
        Produto produto = produtoRepository.findById(id);
        System.out.println("Produto de codigo: "+id+": "+produto);
        if (produto == null) {
            return null;
        } else {
            return Produto.toProdutoModel(produto);
        }
    }
}
