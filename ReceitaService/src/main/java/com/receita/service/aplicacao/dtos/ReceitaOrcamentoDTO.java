package com.receita.service.aplicacao.dtos;

import java.time.LocalDate;
import com.receita.service.dominio.entidades.ReceitaOrcamentoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaOrcamentoDTO {
    private long id;
    private LocalDate data;
    private double impostoEstadual;
    private double impostoFederal;
    private double valorFinal;

    public static ReceitaOrcamentoDTO fromModel(ReceitaOrcamentoModel receitaOrcamentoModel){
        return new ReceitaOrcamentoDTO(
            receitaOrcamentoModel.getId(),
            receitaOrcamentoModel.getData(),
            receitaOrcamentoModel.getImpostoEstadual(),
            receitaOrcamentoModel.getImpostoFederal(),
            receitaOrcamentoModel.getValorFinal()
        );
    }
}