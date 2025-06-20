package com.imposto.impostoservice.dominio.factories;

import com.imposto.impostoservice.dominio.impostos.IImposto;
import com.imposto.impostoservice.dominio.impostos.ImpostoPE;
import com.imposto.impostoservice.dominio.impostos.ImpostoRS;
import com.imposto.impostoservice.dominio.impostos.ImpostoSP;

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
