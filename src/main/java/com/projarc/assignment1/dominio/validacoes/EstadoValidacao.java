package com.projarc.assignment1.dominio.validacoes;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public class EstadoValidacao extends EnderecoValidacao {
    private static final Set<String> ESTADOS_ATENDIDOS = new HashSet<>(Arrays.asList("SP", "RS", "PE"));

    @Override
    public void check(OrcamentoModel orcamento) {
        String estado = orcamento.getEndereco().getEstado();
        if (!ESTADOS_ATENDIDOS.contains(estado)) {
            throw new IllegalArgumentException("Estado não atendido: " + estado);
        }
        if (next != null) next.check(orcamento);
    }
}

