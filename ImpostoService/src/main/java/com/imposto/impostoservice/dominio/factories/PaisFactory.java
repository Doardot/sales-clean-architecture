package com.imposto.impostoservice.dominio.factories;

import com.imposto.impostoservice.dominio.impostos.IImposto;
import com.imposto.impostoservice.dominio.impostos.ImpostoFederal;

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
