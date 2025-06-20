package com.imposto.service.dominio.factories;

import com.imposto.service.dominio.impostos.IImposto;
import com.imposto.service.dominio.impostos.ImpostoFederal;

public class PaisFactory {
    public static IImposto obterImpostoPorPais(String pais) {
        switch (pais) {
            case "BR":
                return new ImpostoFederal();
            default:
                throw new IllegalArgumentException("País não atendido: " + pais);
        }
    }
}
