package com.imposto.impostoservice.dominio.entidades;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.imposto.impostoservice.aplicacao.dtos.ItemModelDTO;

public class ItemModel {
    private String nome;
    private double valorUnitario;
    private int quantidade;
    private boolean essencial;

    public ItemModel(String nome, double valorUnitario, int quantidade, boolean essencial) {
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.essencial = essencial;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isEssencial() {
        return essencial;
    }

    public double calcularCustoTotal() {
        return valorUnitario * quantidade;
    }

    public static ItemModel toItemModel(ItemModelDTO dto) {
        return new ItemModel(dto.getNome(), dto.getValorUnitario(), dto.getQuantidade(), dto.isEssencial());
    }

    public ArrayList<ItemModel> toItemModelList(ArrayList<ItemModelDTO> dtoList) {
        return dtoList.stream()
                .map(ItemModel::toItemModel)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}