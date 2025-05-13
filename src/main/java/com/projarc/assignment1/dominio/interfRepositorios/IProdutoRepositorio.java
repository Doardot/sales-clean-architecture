package com.projarc.assignment1.dominio.interfRepositorios;

import java.util.List;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;

public interface IProdutoRepositorio {
    List<ProdutoModel> todos();
    ProdutoModel consultaPorId(long codigo);
}
