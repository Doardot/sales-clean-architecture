package com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.ItemPedido;

public interface ItemPedidoJPA_ItfRep extends CrudRepository<ItemPedido,Long>{
    @Override
    List<ItemPedido> findAll();
    Optional<ItemPedido> findById(long id);
}
