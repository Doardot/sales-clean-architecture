package com.projarc.assignment1.interfaceAdaptadora.controladores;

import java.time.LocalDate;
import java.util.List;

import com.projarc.assignment1.aplicacao.casosDeUso.ListarOrcamentoPorPeriodoUC;
import com.projarc.assignment1.aplicacao.dtos.PeriodoDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.projarc.assignment1.aplicacao.casosDeUso.CriaOrcamentoUC;
import com.projarc.assignment1.aplicacao.casosDeUso.EfetivaOrcamentoUC;
import com.projarc.assignment1.aplicacao.dtos.OrcamentoDTO;

@RestController
@AllArgsConstructor
public class OrcamentoController {
    private CriaOrcamentoUC criaOrcamento;
    private EfetivaOrcamentoUC efetivaOrcamento;
    private ListarOrcamentoPorPeriodoUC listarOrcamentoPorPeriodoUC;

    @PostMapping("novoOrcamento")
    @CrossOrigin(origins = "*")
    public OrcamentoDTO novoOrcamento(@RequestBody OrcamentoDTO dto){
        return criaOrcamento.run(dto);
    }

    @PostMapping("efetivaOrcamento/{id}")
    @CrossOrigin(origins = "*")
    public OrcamentoDTO efetivaOrcamento(@PathVariable(value="id") long idOrcamento){
        return efetivaOrcamento.run(idOrcamento);
    }

    @GetMapping("listarOrcamentoPorPeriodo")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> listarOrcamentoPorPeriodo(@RequestBody PeriodoDTO periodo){
        LocalDate dataInicio = periodo.getDataInicio();
        LocalDate dataFim = periodo.getDataFim();

        return listarOrcamentoPorPeriodoUC.run(dataInicio, dataFim);
    }
}