package com.receita.service.infra.repositorios;

import com.receita.service.dominio.entidades.RegistroReceita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RegistroReceitaRepository extends JpaRepository<RegistroReceita, Long> {
    List<RegistroReceita> findByDataBetween(LocalDate startDate, LocalDate endDate);
}
