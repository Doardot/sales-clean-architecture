package com.projarc.assignment1.auxiliar;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;

public class PaisValidacao extends EnderecoValidacao {
    private static final Set<String> PAISES_ATENDIDOS = new HashSet<>(Arrays.asList("BR"));

    @Override
    public void check(OrcamentoModel orcamento) {
        String pais = orcamento.getEndereco().getPais();
        if (!PAISES_ATENDIDOS.contains(pais)) {
            throw new IllegalArgumentException("País não atendido: " + pais);
        }
        if (next != null) next.check(orcamento);
    }
}
