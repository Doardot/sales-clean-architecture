package com.projarc.assignment1.auxiliar;

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
