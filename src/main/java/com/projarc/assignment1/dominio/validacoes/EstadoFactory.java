package com.projarc.assignment1.dominio.validacoes;

import com.projarc.assignment1.dominio.entidades.Estado;

public class EstadoFactory {
    public static Estado createEstado(String nome, String sigla) {
        return new Estado(nome, sigla);
    }
}