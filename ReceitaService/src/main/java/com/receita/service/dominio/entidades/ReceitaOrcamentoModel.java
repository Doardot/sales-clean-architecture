package com.receita.service.dominio.entidades;

import java.time.LocalDate;
import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ReceitaOrcamentoModel {
    private long id;
    private LocalDate data = LocalDate.now();
    private double impostoEstadual;
    private double impostoFederal;
    private double valorFinal;
}
