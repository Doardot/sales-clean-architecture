package com.projarc.assignment1.dominio.servicos;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.validacoes.PaisValidacao;
import com.projarc.assignment1.dominio.validacoes.EstadoValidacao;
import com.projarc.assignment1.dominio.validacoes.EnderecoValidacao;
import com.projarc.assignment1.dominio.descontos.IDesconto;
import com.projarc.assignment1.dominio.impostos.IImposto;

import java.util.List;

public class OrcamentoService {
    private final EnderecoValidacao validacaoEndereco;
    private final List<IDesconto> descontos;
    private final List<IImposto> impostos;

    public OrcamentoService(List<IDesconto> descontos, List<IImposto> impostos) {
        // Monta a cadeia de validação de endereço
        this.validacaoEndereco = new PaisValidacao();
        this.validacaoEndereco.linkWith(new EstadoValidacao());
        this.descontos = descontos;
        this.impostos = impostos;
    }

    public void validarEndereco(OrcamentoModel orcamento) {
        validacaoEndereco.check(orcamento);
    }

    public double calcularDescontos(OrcamentoModel orcamento) {
        return descontos.stream().mapToDouble(d -> d.calcularDesconto(orcamento)).sum();
    }

    public double calcularImpostos(OrcamentoModel orcamento) {
        return impostos.stream().mapToDouble(i -> i.calcularImposto(orcamento)).sum();
    }
}
