package com.receita.service.dominio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.receita.service.dominio.entidades.ReceitaOrcamentoModel;
import com.receita.service.dominio.entidades.RegistroReceita;
import com.receita.service.dominio.interfRepositorios.IRegistroReceitaRepository;

@Service
public class ServicoDeReceita {
    private final IRegistroReceitaRepository registroReceitaRepository;

    @Autowired
    public ServicoDeReceita(IRegistroReceitaRepository registroReceitaRepository){
        this.registroReceitaRepository = registroReceitaRepository;
    }

    public double SalvarReceitaOrcamento(ReceitaOrcamentoModel receitaOrcamentoModel) {
        double valorImpostos = receitaOrcamentoModel.getImpostoEstadual() + receitaOrcamentoModel.getImpostoFederal();
        RegistroReceita registro = new RegistroReceita(
            receitaOrcamentoModel.getData(),
            receitaOrcamentoModel.getValorFinal(),
            valorImpostos
        );
        registroReceitaRepository.save(registro);
        return receitaOrcamentoModel.getValorFinal();
    }
}