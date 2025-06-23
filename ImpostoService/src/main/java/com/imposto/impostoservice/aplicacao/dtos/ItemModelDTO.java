package com.imposto.impostoservice.aplicacao.dtos;

import com.imposto.impostoservice.dominio.entidades.ItemModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModelDTO {
    private double valorUnitario;
    private int quantidade;
    private boolean essencial;

    public static ItemModelDTO fromModel(ItemModel itemModel){
        return new ItemModelDTO(
            itemModel.getValorUnitario(),
            itemModel.getQuantidade(),
            itemModel.isEssencial()
        );
    }
}