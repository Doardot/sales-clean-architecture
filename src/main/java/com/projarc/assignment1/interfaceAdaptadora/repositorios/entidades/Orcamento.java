package com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades;

import com.projarc.assignment1.dominio.entidades.EnderecoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Orcamento(LocalDate data, String nomeCliente, Endereco endereco, double somatorioCustoItens, double impostoEstadual, double impostoFederal, double desconto, double valorFinal, OrcamentoModel.Status status, List<ItemPedido> itens) {
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.somatorioCustoItens = somatorioCustoItens;
        this.impostoEstadual = impostoEstadual;
        this.impostoFederal = impostoFederal;
        this.desconto = desconto;
        this.valorFinal = valorFinal;
        this.status = status;
        this.itens = itens;
    }

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
