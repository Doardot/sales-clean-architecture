package com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades;

import com.projarc.assignment1.dominio.entidades.EnderecoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Orcamento {
    @Id
    private long id;
    private LocalDate data = LocalDate.now();
    private String nomeCliente;
    @Embedded
    private Endereco endereco;
    private double somatorioCustoItens;
    private double impostoEstadual;
    private double impostoFederal;
    private double desconto;
    private double valorFinal;
    private OrcamentoModel.Status status = OrcamentoModel.Status.PENDENTE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orcamento_id")
    private List<ItemPedido> itens;

    public Orcamento() { }

    public static OrcamentoModel toOrcamentoModel(Orcamento orcamento) {
        EnderecoModel enderecoModel = new EnderecoModel(
                orcamento.getEndereco().getEstado(),
                orcamento.getEndereco().getPais()
        );

        return new OrcamentoModel(
            orcamento.getId(),
            orcamento.getData(),
            orcamento.getNomeCliente(),
            orcamento.getItens().stream().map(ItemPedido::toItemPedidoModel).toList(),
            enderecoModel,
            orcamento.getSomatorioCustoItens(),
            orcamento.getImpostoEstadual(),
            orcamento.getImpostoFederal(),
            orcamento.getDesconto(),
            orcamento.getValorFinal(),
            orcamento.getStatus()
        );
    }

}
