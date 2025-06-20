package com.imposto.service.dominio.factories;

import com.imposto.service.dominio.impostos.IImposto;
import com.imposto.service.dominio.impostos.ImpostoPE;
import com.imposto.service.dominio.impostos.ImpostoRS;
import com.imposto.service.dominio.impostos.ImpostoSP;

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
