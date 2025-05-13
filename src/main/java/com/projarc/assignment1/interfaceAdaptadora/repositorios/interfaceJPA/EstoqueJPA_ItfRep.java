package com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.ItemDeEstoque;

public interface EstoqueJPA_ItfRep extends CrudRepository<ItemDeEstoque,Long>{
    @Override
    List<ItemDeEstoque> findAll();
    Optional<ItemDeEstoque> findById(long id);
}
