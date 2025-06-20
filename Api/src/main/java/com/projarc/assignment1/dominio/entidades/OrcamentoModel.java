package com.projarc.assignment1.dominio.entidades;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrcamentoModel {
    public enum Status {
        PENDENTE, EFETIVADO, CANCELADO
    }

    private long id;
    private LocalDate data = LocalDate.now();
    private String nomeCliente;
    private List<ItemPedidoModel> itens;
    private EnderecoModel endereco;
    private double somatorioCustoItens;
    private double impostoEstadual;
    private double impostoFederal;
    private double desconto;
    private double valorFinal;
    private Status status = Status.PENDENTE;

    public OrcamentoModel() {
        this.itens = new LinkedList<>();
    }

    public void addItensPedido(PedidoModel pedido) {
        for (ItemPedidoModel itemPedido : pedido.getItens()) {
            itens.add(itemPedido);
        }
    }

    public boolean estaValido() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataLimite = data.plusDays(21);

        return status == Status.PENDENTE && dataAtual.isBefore(dataLimite);
    }
}
