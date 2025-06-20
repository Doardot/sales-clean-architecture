package com.projarc.assignment1.aplicacao.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModelDTO {
    private String nome;
    private double valorUnitario;
    private int quantidade;
    private boolean essencial;
}