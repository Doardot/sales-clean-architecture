package com.projarc.assignment1.dominio.entidades;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class OrcamentoModel {
    private enum Status {
        PENDENTE, EFETIVADO
    }

    private long id;
    private LocalDate data;
    private String nomeCliente;
    private String estado;
    private String pais;
    private List<ItemPedidoModel> itens;
    private double custoItens;
    private double impostoEstadual;
    private double impostoFederal;
    private double desconto;
    private double custoConsumidor;
    private Status status;

    public OrcamentoModel(long id) {
        this.id = id;
        this.itens = new LinkedList<>();
        this.status = Status.PENDENTE;
    }

    public OrcamentoModel() {
        this.itens = new LinkedList<>();
        this.status = Status.PENDENTE;
    }

    public void addItensPedido(PedidoModel pedido) {
        for (ItemPedidoModel itemPedido : pedido.getItens()) {
            itens.add(itemPedido);
        }
    }

    public double calcularTotalBruto() {
        double totalBruto = 0;
        for (ItemPedidoModel item : itens) {
            totalBruto += item.calcularSubtotal();
        }
        return totalBruto;
    }

    public boolean estaValido() {
        return data.plusDays(21).isAfter(LocalDate.now());
    }

    public void efetivar() {
        if (!estaValido())
            throw new IllegalStateException("Orçamento expirado");
        this.status = Status.EFETIVADO;
    }

    public List<ItemPedidoModel> getItens() {
        return itens;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCustoItens() {
        return custoItens;
    }

    public void setCustoItens(double custoItens) {
        this.custoItens = custoItens;
    }

    public double getImpostoEstadual() {
        return impostoEstadual;
    }

    public double getImpostoFederal() {
        return impostoFederal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getCustoConsumidor() {
        return custoConsumidor;
    }

    public void setCustoConsumidor(double custoConsumidor) {
        this.custoConsumidor = custoConsumidor;
    }
}
