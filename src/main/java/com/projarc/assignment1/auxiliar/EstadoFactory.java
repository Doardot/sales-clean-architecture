package com.projarc.assignment1.auxiliar;

public class EstadoFactory {
    public static IImposto obterImpostoPorEstado(String estado) {
        switch (estado) {
            case "SP":
                return new ImpostoSP();
            case "RS":
                return new ImpostoRS();
            case "PE":
                return new ImpostoPE();
            default:
                throw new IllegalArgumentException("Estado não atendido: " + estado);
        }
    }
}
