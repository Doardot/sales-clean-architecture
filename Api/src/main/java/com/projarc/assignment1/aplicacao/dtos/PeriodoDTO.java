package com.projarc.assignment1.aplicacao.dtos;

import java.time.LocalDate;

public class PeriodoDTO {
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
}