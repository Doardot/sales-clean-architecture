package com.projarc.assignment1.aplicacao.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImpostoDTO {
    private double impostoFederal;
    private double impostoEstadual;
}
