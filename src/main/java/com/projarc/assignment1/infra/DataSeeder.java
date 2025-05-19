package com.projarc.assignment1.infra;

import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades.*;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.EstoqueJPA_ItfRep;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.OrcamentoJPA_ItfRep;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.ProdutoJPA_ItfRep;
import com.projarc.assignment1.interfaceAdaptadora.repositorios.interfaceJPA.ItemPedidoJPA_ItfRep;
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
    private final ItemPedidoJPA_ItfRep itemPedidoRepository;

    @Override
    public void run(String... args) {
        Produto produtoTest1 = new Produto("Maça", 10.0);
        Produto produtoTest2 = new Produto("Banana*", 10.0);
        Produto produtoTest3 = new Produto("Cenoura", 15.0);
        Produto produtoTest4 = new Produto("Bolo", 20.0);
        Produto produtoTest5 = new Produto("Esponja", 5.0);
        Produto produtoTest6 = new Produto("Arroz", 8.0);
        Produto produtoTest7 = new Produto("Feijão", 12.0);
        Produto produtoTest8 = new Produto("Suco", 4.0);
        Produto produtoTest9 = new Produto("Atum", 18.0);
        Produto produtoTest10 = new Produto("Frango", 22.0);

        produtoRepository.save(produtoTest1);
        produtoRepository.save(produtoTest2);
        produtoRepository.save(produtoTest3);
        produtoRepository.save(produtoTest4);
        produtoRepository.save(produtoTest5);
        produtoRepository.save(produtoTest6);
        produtoRepository.save(produtoTest7);
        produtoRepository.save(produtoTest8);
        produtoRepository.save(produtoTest9);
        produtoRepository.save(produtoTest10);


        estoqueRepository.save(new ItemDeEstoque(produtoTest1, 10, 1, 20));
        estoqueRepository.save(new ItemDeEstoque(produtoTest2, 24, 12, 46));

        ItemPedido itemPedido1 = new ItemPedido(5, produtoTest1);
        ItemPedido itemPedido2 = new ItemPedido(2, produtoTest2);
        ItemPedido itemPedido3 = new ItemPedido(1, produtoTest3);
        ItemPedido itemPedido4 = new ItemPedido(1, produtoTest4);
        ItemPedido itemPedido5 = new ItemPedido(1, produtoTest5);
        ItemPedido itemPedido6 = new ItemPedido(1, produtoTest6);
        ItemPedido itemPedido7 = new ItemPedido(1, produtoTest7);
        ItemPedido itemPedido8 = new ItemPedido(1, produtoTest8);
        ItemPedido itemPedido9 = new ItemPedido(1, produtoTest9);
        ItemPedido itemPedido10 = new ItemPedido(1, produtoTest10);

        itemPedidoRepository.save(itemPedido1);
        itemPedidoRepository.save(itemPedido2);
        itemPedidoRepository.save(itemPedido3);
        itemPedidoRepository.save(itemPedido4);
        itemPedidoRepository.save(itemPedido5);
        itemPedidoRepository.save(itemPedido6);
        itemPedidoRepository.save(itemPedido7);
        itemPedidoRepository.save(itemPedido8);
        itemPedidoRepository.save(itemPedido9);
        itemPedidoRepository.save(itemPedido10);

        Endereco endereco1 = new Endereco("RS", "BR");
        Endereco endereco2 = new Endereco("SP", "BR");
        Endereco endereco3 = new Endereco("PE", "BR");

        orcamentoRepository.save(new Orcamento(LocalDate.parse("2025-10-01"),
        "Cliente Teste", endereco1,
        0.0, 0.0, 0.0, 0.0, 0.0, OrcamentoModel.Status.PENDENTE,
        List.of(new ItemPedido(4, produtoTest1), new ItemPedido(3,
        produtoTest2))));
    }
}
