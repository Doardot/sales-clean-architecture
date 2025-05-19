package com.projarc.assignment1.dominio.validacoes;

import com.projarc.assignment1.dominio.entidades.Pais;

public class PaisFactory {

    public static Pais criarPais(String nome, String sigla) {
        return new Pais(nome, sigla);
    }
}