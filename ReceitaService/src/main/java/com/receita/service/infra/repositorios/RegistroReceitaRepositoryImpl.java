package com.receita.service.infra.repositorios;

import com.receita.service.dominio.entidades.RegistroReceita;
import com.receita.service.dominio.interfRepositorios.IRegistroReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RegistroReceitaRepositoryImpl implements IRegistroReceitaRepository {

    private final RegistroReceitaRepository registroReceitaRepository;

    @Autowired
    public RegistroReceitaRepositoryImpl(RegistroReceitaRepository registroReceitaRepository) {
        this.registroReceitaRepository = registroReceitaRepository;
    }

    @Override
    public void save(RegistroReceita registro) {
        registroReceitaRepository.save(registro);
    }

    @Override
    public List<RegistroReceita> findByDataBetween(LocalDate startDate, LocalDate endDate) {
        return registroReceitaRepository.findByDataBetween(startDate, endDate);
    }
}
