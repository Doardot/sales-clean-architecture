package com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades;

import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
    @Id
    private long id;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getId() + "'" +
            ", produto='" + getProduto() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            "}";
    }

    public static ItemPedido fromItemPedidoModel(ItemPedidoModel itemPedidoModel) {
        return new ItemPedido(itemPedidoModel.getProduto().getId(), itemPedidoModel.getQuantidade(), Produto.fromProdutoModel(itemPedidoModel.getProduto()));
    }

    public ItemPedidoModel toItemPedidoModel() {
        return new ItemPedidoModel(Produto.toProdutoModel(produto), quantidade);
    }
}
