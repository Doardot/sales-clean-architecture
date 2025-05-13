package com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.Produto;

public interface ProdutoJPA_ItfRep extends CrudRepository<Produto, Long>{
    @Override
    List<Produto> findAll();
    Produto findById(long id);
}
