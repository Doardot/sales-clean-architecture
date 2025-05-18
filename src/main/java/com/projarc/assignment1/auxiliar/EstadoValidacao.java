package com.projarc.assignment1.auxiliar;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public class EstadoValidacao extends EnderecoValidacao {
    private static final Set<String> ESTADOS_ATENDIDOS = new HashSet<>(Arrays.asList("SP", "RS", "PE"));

    @Override
    public void check(OrcamentoModel orcamento) {
        if (!ESTADOS_ATENDIDOS.contains(orcamento.getEstado())) {
            throw new IllegalArgumentException("Estado não atendido: " + orcamento.getEstado());
        }
        if (next != null) next.check(orcamento);
    }
}
