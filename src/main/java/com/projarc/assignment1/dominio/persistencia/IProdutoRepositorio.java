package com.projarc.assignment1.dominio.persistencia;

import java.util.List;

import com.projarc.assignment1.dominio.modelos.ProdutoModel;

public interface IProdutoRepositorio {
    List<ProdutoModel> todos();
    ProdutoModel consultaPorId(long codigo);
}
