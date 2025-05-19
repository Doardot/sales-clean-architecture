package com.projarc.assignment1.dominio.factories;

import com.projarc.assignment1.dominio.impostos.IImposto;
import com.projarc.assignment1.dominio.impostos.ImpostoFederal;

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
