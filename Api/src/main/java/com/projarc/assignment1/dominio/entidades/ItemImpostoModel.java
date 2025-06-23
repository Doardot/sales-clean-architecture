package com.projarc.assignment1.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemImpostoModel {
    private double valorUnitario;
    private int quantidade;
    private boolean essencial;
}