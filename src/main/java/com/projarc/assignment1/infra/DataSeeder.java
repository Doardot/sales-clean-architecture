package com.projarc.assignment1.infra;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.*;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.EstoqueJPA_ItfRep;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.OrcamentoJPA_ItfRep;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.ProdutoJPA_ItfRep;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final EstoqueJPA_ItfRep estoqueRepository;
    private final OrcamentoJPA_ItfRep orcamentoRepository;
    private final ProdutoJPA_ItfRep produtoRepository;

    @Override
    public void run(String... args) {
        Produto produtoTest1 = new Produto("Maça", 10.0);
        Produto produtoTest2 = new Produto("Banana", 10.0);

        produtoRepository.save(produtoTest1);
        produtoRepository.save(produtoTest2);

        estoqueRepository.save(new ItemDeEstoque(produtoTest1, 10, 1, 20));
        estoqueRepository.save(new ItemDeEstoque(produtoTest2, 24, 12, 46));

        Endereco endereco = new Endereco("SP", "Brasil");

        orcamentoRepository.save(new Orcamento(9, LocalDate.parse("2025-10-01"), "Cliente Teste", endereco,
                0.0, 0.0, 0.0, 0.0, 0.0, OrcamentoModel.Status.PENDENTE,
                List.of(new ItemPedido(10, 4, produtoTest1), new ItemPedido(93, 3, produtoTest2))));
    }
}
