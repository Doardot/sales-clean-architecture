package com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades;



import com.projarc.assignment1.dominio.entidades.ProdutoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Produto {
    @Id
    private long id;
    private String descricao;
    private double precoUnitario;

    protected Produto(){ }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getId() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", precoUnitario='" + getPrecoUnitario() + "'" +
            "}";
    }

    public static Produto fromProdutoModel(ProdutoModel pModel){
        return new Produto(pModel.getId(),pModel.getDescricao(),pModel.getPrecoUnitario());
    }

    public static ProdutoModel toProdutoModel(Produto prod){
        return new ProdutoModel(prod.getId(),prod.getDescricao(),prod.getPrecoUnitario());
    }
}
