package com.receita.service.dominio.interfRepositorios;

import com.receita.service.dominio.entidades.RegistroReceita;

import java.time.LocalDate;
import java.util.List;

public interface IRegistroReceitaRepository {
    void save(RegistroReceita registro);
    List<RegistroReceita> findByDataBetween(LocalDate startDate, LocalDate endDate);
}
