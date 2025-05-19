package com.projarc.assignment1.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pais {
    private String nome;
    private String sigla;
}
