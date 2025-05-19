package com.projarc.assignment1.dominio.factories;

import com.projarc.assignment1.dominio.impostos.IImposto;
import com.projarc.assignment1.dominio.impostos.ImpostoPE;
import com.projarc.assignment1.dominio.impostos.ImpostoRS;
import com.projarc.assignment1.dominio.impostos.ImpostoSP;

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
