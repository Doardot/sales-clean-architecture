package com.projarc.assignment1.dominio.interfRepositorios;

import com.projarc.assignment1.dominio.entidades.ProdutoModel;

public interface IProdutoRepositorio {
    ProdutoModel consultaProdutoPorId(long id);
}
