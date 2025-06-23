package com.imposto.impostoservice.aplicacao.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrcamentoDTO {
    private double impostFederal;
    private double impostoEstadual;
}
