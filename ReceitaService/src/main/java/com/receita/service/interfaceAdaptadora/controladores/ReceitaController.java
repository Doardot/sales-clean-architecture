package com.receita.service.interfaceAdaptadora.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.receita.service.aplicacao.casosDeUso.SalvarReceitaOrcamentoUC;
import com.receita.service.aplicacao.dtos.ReceitaOrcamentoDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/receitaService")
@AllArgsConstructor
public class ReceitaController {
    private final SalvarReceitaOrcamentoUC salvarReceitaOrcamentoUC;

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return ("Imposto service test");
    }

    @PostMapping("/salvarReceita")
    @CrossOrigin(origins = "*")
    public double calcularImposto(@RequestBody ReceitaOrcamentoDTO receitaOrcamentoDTO) {
        return salvarReceitaOrcamentoUC.run(receitaOrcamentoDTO);
    }
}